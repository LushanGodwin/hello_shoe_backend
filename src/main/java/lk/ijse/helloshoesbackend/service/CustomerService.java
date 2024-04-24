package lk.ijse.helloshoesbackend.service;

import lk.ijse.helloshoesbackend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService{
    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomer(String id);

    List<CustomerDTO> getAllCustomer();

    boolean deleteCustomer(String id);

    boolean updateCustomer(String id, CustomerDTO customerDTO);
}
