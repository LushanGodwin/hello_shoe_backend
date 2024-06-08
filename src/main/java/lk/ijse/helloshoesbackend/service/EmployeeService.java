package lk.ijse.helloshoesbackend.service;

import lk.ijse.helloshoesbackend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployee(String id);

    void updateEmployee(String id,EmployeeDTO employeeDTO);

    void deleteEmployee(String id);

    List<EmployeeDTO> getAllEmployees();
}
