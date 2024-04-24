package lk.ijse.helloshoesbackend.util;

import lk.ijse.helloshoesbackend.dto.CustomerDTO;
import lk.ijse.helloshoesbackend.dto.SupplierDTO;
import lk.ijse.helloshoesbackend.entity.CustomerEntity;
import lk.ijse.helloshoesbackend.entity.SupplierEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper modelMapper;

    public CustomerDTO toCustomerDTO(Optional<CustomerEntity> customerEntity){
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customerEntities){
        return modelMapper.map(customerEntities, List.class);
    }

    public SupplierDTO toSupplierDTO(Optional<SupplierEntity> supplierEntity){
        return modelMapper.map(supplierEntity, SupplierDTO.class);
    }

    public SupplierEntity toSupplierEntity(SupplierDTO supplierDTO){
        return modelMapper.map(supplierDTO, SupplierEntity.class);
    }

    public List<SupplierDTO> toSupplierDTOList(List<SupplierEntity> supplierEntities){
        return modelMapper.map(supplierEntities, List.class);
    }
}
