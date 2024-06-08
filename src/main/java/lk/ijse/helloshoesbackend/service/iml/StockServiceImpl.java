package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.StockDTO;
import lk.ijse.helloshoesbackend.entity.BranchEntity;
import lk.ijse.helloshoesbackend.entity.EmployeeEntity;
import lk.ijse.helloshoesbackend.entity.SizeEntity;
import lk.ijse.helloshoesbackend.entity.StockEntity;
import lk.ijse.helloshoesbackend.exception.NotFoundException;
import lk.ijse.helloshoesbackend.repository.*;
import lk.ijse.helloshoesbackend.service.StockService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class StockServiceImpl implements StockService {

    private final StockDao stockDao;
    private final SupplierDao supplierDao;
    private final InventoryDao inventoryDao;
    private final SizeDao sizeDao;
    private final EmployeeDao employeeDao;
    private final BranchDao branchDao;
    private final Mapping mapping;

    @Override
    public String getStockId() {
        return getNextStockId();
    }

    private String getNextStockId() {
        StockEntity stockEntity = stockDao.findFirstByOrderByStockIdDesc();
        return (stockEntity != null)
                ? String.format("St-%03d",
                Integer.parseInt(stockEntity.getStockId()
                        .replace("St-", "")) + 1)
                : "St-001";
    }

    @Override
    public void saveStock(StockDTO stockDTO, String email) {
        EmployeeEntity byEmail = employeeDao.findByEmail(email);
        Optional<BranchEntity> branch = branchDao.findById(byEmail.getBranch().getBranchId());
        BranchEntity branchEntity = branch.get();
        SizeEntity sizeEntity = sizeDao.findById(stockDTO.getSizeCode()).get();

        stockDao.save(new StockEntity(
                getNextStockId(),
                new Date(),
                stockDTO.getQuantity(),
                stockDTO.getUnitBuyingPrice(),
                stockDTO.getUnitSellingPrice(),
                supplierDao.findById(stockDTO.getSupplierCode()).get(),
                inventoryDao.findById(stockDTO.getItemCode()).get(),
                branchEntity,
                sizeEntity
                ));
    }

    @Override
    public List<StockDTO> getAllStock() {
        return mapping.toStockEntity(stockDao.findAll());
    }

    @Override
    public void updateStock(StockDTO stockDTO, String stockId) {
        Optional<StockEntity> stockEntity = stockDao.findById(stockId);
        if (stockEntity.isEmpty()) throw new NotFoundException("Stock Not Found");
        StockEntity stock = stockEntity.get();
        stock.setQuantity(stockDTO.getQuantity());
        stock.setUnitBuyingPrice(stockDTO.getUnitBuyingPrice());
        stock.setUnitSellingPrice(stockDTO.getUnitSellingPrice());
        stock.setSupplierEntity(supplierDao.findById(stockDTO.getSupplierCode()).get());
        stock.setItemEntity(inventoryDao.findById(stockDTO.getItemCode()).get());
        stock.setSizeEntity(sizeDao.findById(stockDTO.getSizeCode()).get());
    }

    @Override
    public void deleteStock(String id) {
        if (!stockDao.existsById(id)) throw new NotFoundException("Stock Not Found");
        stockDao.deleteById(id);
    }
}
