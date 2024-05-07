package lk.ijse.helloshoesbackend.util;

import lk.ijse.helloshoesbackend.dto.*;
import lk.ijse.helloshoesbackend.entity.*;
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

    public List<CustomerEntity> toCustomerEntityList(List<CustomerDTO> customerDTOS){
        return modelMapper.map(customerDTOS, List.class);
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

    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public UserDTO toUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public EmployeeEntity toEmployeeEntity(EmployeeDTO employeeDTO){
        return modelMapper.map(employeeDTO, EmployeeEntity.class);
    }

    public EmployeeDTO toEmployeeDTO(Optional<EmployeeEntity> employeeEntity){
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> toEmployeeDTOList(List<EmployeeEntity> employeeEntities) {
        return modelMapper.map(employeeEntities,List.class);
    }

    public List<EmployeeEntity> toEmployeeEntityList(List<EmployeeDTO> employeeDTOS){
        return modelMapper.map(employeeDTOS, List.class);
    }

    public GenderDTO toGenderDTO(GenderEntity genderEntity){
        return modelMapper.map(genderEntity, GenderDTO.class);
    }

    public GenderEntity toGenderEntity(GenderDTO genderDTO){
        return modelMapper.map(genderDTO, GenderEntity.class);
    }

    public List<GenderDTO> toGenderDTOList(List<GenderEntity> genderEntities){
        return modelMapper.map(genderEntities, List.class);
    }

    public OccasionDTO toOccasionDTO(OccasionEntity occasionEntity){
        return modelMapper.map(occasionEntity, OccasionDTO.class);
    }

    public OccasionEntity toOccasionEntity(OccasionDTO occasionDTO){
        return modelMapper.map(occasionDTO, OccasionEntity.class);
    }

    public List<OccasionDTO> toOccasionDTOList(List<OccasionEntity> occasionEntities){
        return modelMapper.map(occasionEntities, List.class);
    }

    public VarietyDTO toVarietyDTO(VarietyEntity varietyEntity){
        return modelMapper.map(varietyEntity, VarietyDTO.class);
    }

    public VarietyEntity toVarietyEntity(VarietyDTO varietyDTO){
        return modelMapper.map(varietyDTO, VarietyEntity.class);
    }

    public List<VarietyDTO> toVarietyDTOList(List<VarietyEntity> varietyEntities){
        return modelMapper.map(varietyEntities, List.class);
    }

    public ItemDTO toItemDTO(Optional<ItemEntity> itemEntity){
        return modelMapper.map(itemEntity, ItemDTO.class);
    }

    public ItemEntity toItemEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, ItemEntity.class);
    }
    public List<ItemDTO> toItemDTOList(List<ItemEntity> itemEntities){
        return modelMapper.map(itemEntities, List.class);
    }
}
