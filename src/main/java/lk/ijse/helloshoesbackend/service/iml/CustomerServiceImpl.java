package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.Enum.Level;
import lk.ijse.helloshoesbackend.dto.CustomerDTO;
import lk.ijse.helloshoesbackend.entity.CustomerEntity;
import lk.ijse.helloshoesbackend.exception.NotFoundException;
import lk.ijse.helloshoesbackend.repository.CustomerDao;
import lk.ijse.helloshoesbackend.service.CustomerService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;
    private final Mapping mapping;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustomerCode(getNextCustomerId());
        customerDTO.setLevel(Level.NEW);
        customerDTO.setTotalPoints(0);
        customerDTO.setJoinDate(new Date());
        customerDTO.setPurchase_time_date(new Timestamp(System.currentTimeMillis()));
        return mapping.toCustomerDTO(java.util.Optional.of(customerDao.save(mapping.toCustomerEntity(customerDTO))));
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        if (!customerDao.existsById(id)) throw new NotFoundException("Customer Not Found");
        return mapping.toCustomerDTO(customerDao.findById(id));
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return mapping.toCustomerDTOList(customerDao.findAll());
    }

    @Override
    public boolean deleteCustomer(String id) {
        Optional<CustomerEntity> customer = customerDao.findById(id);
        if (customer.isPresent()) {
            customerDao.delete(customer.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {
        Optional<CustomerEntity> customer = customerDao.findById(id);
        if (customer.isPresent()) {
            customer.get().setCustomer_name(customerDTO.getCustomer_name());
            customer.get().setGender(customerDTO.getGender());
            /*customer.get().setJoinDate(customerDTO.getJoinDate());
            customer.get().setLevel(customerDTO.getLevel());
            customer.get().setTotalPoints(customerDTO.getTotalPoints());*/
            customer.get().setDob(customerDTO.getDob());
            customer.get().setAddress_line_01(customerDTO.getAddress_line_01());
            customer.get().setAddress_line_02(customerDTO.getAddress_line_02());
            customer.get().setAddress_line_03(customerDTO.getAddress_line_03());
            customer.get().setAddress_line_04(customerDTO.getAddress_line_04());
            customer.get().setPostalCode(customerDTO.getPostalCode());
            customer.get().setContact(customerDTO.getContact());
            customer.get().setEmail(customerDTO.getEmail());
            /*customer.get().setPurchase_time_date(customerDTO.getPurchase_time_date());*/
        } else {
            throw new NotFoundException("Customer not found");
        }
    }

    @Override
    public String getCustomerId() {
        return getNextCustomerId();
    }

    private String getNextCustomerId() {
        CustomerEntity firstByOrderByCustomerCodeDesc = customerDao.findFirstByOrderByCustomerCodeDesc();
        return (firstByOrderByCustomerCodeDesc != null)
                ? String.format("Cust-%03d", Integer.parseInt(firstByOrderByCustomerCodeDesc.getCustomerCode().replace("Cust-", "")) + 1)
                : "Cust-001";
    }


}
