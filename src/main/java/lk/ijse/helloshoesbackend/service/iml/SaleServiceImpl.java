package lk.ijse.helloshoesbackend.service.iml;

import lk.ijse.helloshoesbackend.Enum.Level;
import lk.ijse.helloshoesbackend.dto.OrderDTO;
import lk.ijse.helloshoesbackend.dto.OrderDetailsDTO;
import lk.ijse.helloshoesbackend.entity.CustomerEntity;
import lk.ijse.helloshoesbackend.entity.OrderEntity;
import lk.ijse.helloshoesbackend.entity.StockEntity;
import lk.ijse.helloshoesbackend.entity.StockSizeOrderDetailsEntity;
import lk.ijse.helloshoesbackend.repository.*;
import lk.ijse.helloshoesbackend.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    private final SaleDao saleServiceDao;

    private final CustomerDao customerServiceDao;

    private final UserDao userServiceDao;

    private final StockDao stockServiceDao;

    private final StockOrderDetailsDao stockOrderDetailsServiceDao;
    @Override
    public String getNextOrderId() {
        return getOrderId();
    }

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderNo(orderDTO.getOrderNo());
        orderEntity.setPurchasedDate(new Timestamp(System.currentTimeMillis()));
        orderEntity.setPaymentMethod(orderDTO.getPaymentMethod());
        orderEntity.setTotalAmount(orderDTO.getTotalAmount());
        orderEntity.setPaidAmount(orderDTO.getPaidAmount());
        orderEntity.setBankName(orderDTO.getBankName());
        orderEntity.setBankNo(orderDTO.getBankNo());

        CustomerEntity customerEntity = customerServiceDao.findById(orderDTO.getCustomerId()).orElseThrow();
        orderEntity.setCustomerEntity(customerEntity);

        orderEntity.setUserEntity(userServiceDao.findByEmail(orderDTO.getId()).get());

        saleServiceDao.save(orderEntity);

        for (OrderDetailsDTO detailDTO : orderDTO.getOrderDetailsList()) {
            StockSizeOrderDetailsEntity stockOrderDetailsEntity = new StockSizeOrderDetailsEntity();
            stockOrderDetailsEntity.setStockOrderDetailsId(UUID.randomUUID().toString());
            stockOrderDetailsEntity.setQty(detailDTO.getQty());

            StockEntity stockEntity = stockServiceDao.findById(detailDTO.getStockId()).orElseThrow();
            stockOrderDetailsEntity.setStockEntity(stockEntity);
            stockOrderDetailsEntity.setOrderEntity(orderEntity);

            stockOrderDetailsServiceDao.save(stockOrderDetailsEntity);

            stockEntity.setQuantity(stockEntity.getQuantity() - detailDTO.getQty());
            stockServiceDao.save(stockEntity);
        }

        customerEntity.setTotalPoints(customerEntity.getTotalPoints() + 1);
        customerEntity.setPurchase_time_date(new Timestamp(System.currentTimeMillis()));
        updateCustomerLevel(customerEntity);
    }

    private void updateCustomerLevel(CustomerEntity customerEntity) {
        int points = customerEntity.getTotalPoints();
        if (points < 50) {
            customerEntity.setLevel(Level.NEW);
        } else if (points <= 99) {
            customerEntity.setLevel(Level.BRONZE);
        } else if (points <= 199) {
            customerEntity.setLevel(Level.SILVER);
        } else {
            customerEntity.setLevel(Level.GOLD);
        }
        customerServiceDao.save(customerEntity);
    }
    private String getOrderId() {
        OrderEntity order = saleServiceDao.findFirstByOrderByOrderNoDesc();
        return (order != null)
                ? String.format("Order-%03d",
                Integer.parseInt(order.getOrderNo().
                        replace("Order-", "")) + 1)
                : "Order-001";
    }
}