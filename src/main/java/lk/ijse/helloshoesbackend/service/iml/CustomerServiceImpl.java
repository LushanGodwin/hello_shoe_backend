package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.CustomerDTO;
import lk.ijse.helloshoesbackend.repository.CustomerDao;
import lk.ijse.helloshoesbackend.service.CustomerService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;
    private final Mapping mapping;
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustomer_code(UUID.randomUUID().toString());
        return mapping.toCustomerDTO(java.util.Optional.of(customerDao.save(mapping.toCustomerEntity(customerDTO))));
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        if (!customerDao.existsById(id));
        return mapping.toCustomerDTO(customerDao.findById(id));
    }

    /*@Override
    public List<CustomerDTO> getAllCustomer() {
        return mapping.toCustomerDTOList(customerDao.findAll());
    }*/

}
