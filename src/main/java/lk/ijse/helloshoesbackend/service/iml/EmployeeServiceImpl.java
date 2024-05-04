package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.EmployeeDTO;
import lk.ijse.helloshoesbackend.entity.EmployeeEntity;
import lk.ijse.helloshoesbackend.entity.UserEntity;
import lk.ijse.helloshoesbackend.exception.NotFoundException;
import lk.ijse.helloshoesbackend.repository.EmployeeDao;
import lk.ijse.helloshoesbackend.repository.UserDao;
import lk.ijse.helloshoesbackend.service.EmployeeService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;
    private final Mapping mapping;
    private final UserDao userDao;
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeeCode(getNextEmployeeCode());
        EmployeeEntity employeeEntity = mapping.toEmployeeEntity(employeeDTO);

        String email = employeeDTO.getEmail();
        Optional<UserEntity> byEmail = userDao.findByEmail(email);

        if (byEmail == null){
            throw new NotFoundException("User Not Found");
        }

        UserEntity user = new UserEntity();
        user.setUserId(byEmail.get().getUserId());
        user.setEmail(email);
        user.setPassword(byEmail.get().getPassword());
        user.setRole(byEmail.get().getRole());

        employeeEntity.setUserEntity(user);
        return mapping.toEmployeeDTO(Optional.of(employeeDao.save(employeeEntity)));
    }

    @Override
    public EmployeeDTO getEmployee(String id) {
        if (!employeeDao.existsById(id)){
            throw new NotFoundException("Employee Not Found");
        }
        return mapping.toEmployeeDTO(employeeDao.findById(id));
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return mapping.toEmployeeDTOList(employeeDao.findAll());
    }

    @Override
    public void updateEmployee(String id, EmployeeDTO employeeDTO) {
        if (!employeeDao.existsById(id)){
            throw new NotFoundException("Employee not found");
        }
        Optional<EmployeeEntity> employeeEntity = employeeDao.findById(id);
        EmployeeEntity employeeEntity1 = employeeEntity.get();
        employeeEntity1.setEmployee_name(employeeDTO.getEmployee_name());
        employeeEntity1.setProfile_picture(employeeDTO.getProfile_picture());
        employeeEntity1.setGender(employeeDTO.getGender());
        employeeEntity1.setStatus(employeeDTO.getStatus());
        employeeEntity1.setDesignation(employeeDTO.getDesignation());
        employeeEntity1.setAccess_role(employeeDTO.getAccess_role());
        employeeEntity1.setDob(employeeDTO.getDob());
        employeeEntity1.setAttached_branch(employeeDTO.getAttached_branch());
        employeeEntity1.setAddress_line_01(employeeDTO.getAddress_line_01());
        employeeEntity1.setAddress_line_02(employeeDTO.getAddress_line_02());
        employeeEntity1.setAddress_line_03(employeeDTO.getAddress_line_03());
        employeeEntity1.setAddress_line_04(employeeDTO.getAddress_line_04());
        employeeEntity1.setPostalCode(employeeDTO.getPostalCode());
        employeeEntity1.setContact_no(employeeDTO.getContact_no());
        employeeEntity1.setEmail(employeeDTO.getEmail());
        employeeEntity1.setName_of_the_guardian(employeeDTO.getName_of_the_guardian());
        employeeEntity1.setEmergency_contact_no(employeeDTO.getEmergency_contact_no());
        employeeDao.save(mapping.toEmployeeEntity(employeeDTO));
    }

    @Override
    public boolean deleteEmployee(String id) {
        if (!employeeDao.existsById(id)){
            throw new NotFoundException("Employee not found");
        }
        employeeDao.deleteById(id);
        return true;
    }


    private String getNextEmployeeCode() {
        EmployeeEntity employeeEntity = employeeDao.findFirstByOrderByEmployeeCodeDesc();
        return (employeeEntity != null)
                ? String.format("Emp-%03d",
                Integer.parseInt(employeeEntity.getEmployeeCode()
                        .replace("Emp-", "")) + 1)
                : "Emp-001";
    }
}
