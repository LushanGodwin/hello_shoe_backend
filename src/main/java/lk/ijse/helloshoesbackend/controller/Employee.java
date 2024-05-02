package lk.ijse.helloshoesbackend.controller;

import jakarta.validation.Valid;
import lk.ijse.helloshoesbackend.Enum.Gender;
import lk.ijse.helloshoesbackend.Enum.Role;
import lk.ijse.helloshoesbackend.Enum.Status;
import lk.ijse.helloshoesbackend.dto.EmployeeDTO;
import lk.ijse.helloshoesbackend.service.EmployeeService;
import lk.ijse.helloshoesbackend.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class Employee {

    private final EmployeeService employeeService;

    @GetMapping("/health")
    public String healthCheck(){
        return "Employee Ok";
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public EmployeeDTO saveEmployee(@Valid
                                          @RequestPart ("employee_name") String employee_name,
                                          @RequestPart ("profile_picture") String profile_picture,
                                          @RequestPart ("gender") String gender,
                                          @RequestPart ("status") String status,
                                          @RequestPart ("designation") String designation,
                                          @RequestPart ("access_role") String access_role,
                                          @RequestPart ("dob") String dob,
                                          @RequestPart ("attached_branch") String attached_branch,
                                          @RequestPart ("address_line_01") String address_line_01,
                                          @RequestPart ("address_line_02") String address_line_02,
                                          @RequestPart ("address_line_03") String address_line_03,
                                          @RequestPart ("address_line_04") String address_line_04,
                                          @RequestPart ("postalCode") String postalCode,
                                          @RequestPart ("contact_no") String contact_no,
                                          @RequestPart ("email") String email,
                                          @RequestPart ("name_of_the_guardian") String name_of_the_guardian,
                                          @RequestPart ("emergency_contact_no") String emergency_contact_no,
                                          Errors errors){
        if (errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployee_name(employee_name);
        employeeDTO.setProfile_picture(UtilMatters.convertToBase64(profile_picture));
        employeeDTO.setGender(Gender.valueOf(gender));
        employeeDTO.setStatus(Status.valueOf(status));
        employeeDTO.setDesignation(designation);
        employeeDTO.setAccess_role(Role.valueOf(access_role));
        employeeDTO.setDob(dob);
        employeeDTO.setAttached_branch(attached_branch);
        employeeDTO.setAddress_line_01(address_line_01);
        employeeDTO.setAddress_line_02(address_line_02);
        employeeDTO.setAddress_line_03(address_line_03);
        employeeDTO.setAddress_line_04(address_line_04);
        employeeDTO.setPostalCode(postalCode);
        employeeDTO.setContact_no(contact_no);
        employeeDTO.setEmail(email);
        employeeDTO.setName_of_the_guardian(name_of_the_guardian);
        employeeDTO.setEmergency_contact_no(emergency_contact_no);

        return employeeService.saveEmployee(employeeDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getEmployee(@PathVariable ("id") String id){
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateEmployee(@PathVariable ("id") String id,@Valid
                                            @RequestPart ("employee_name") String employee_name,
                                            @RequestPart ("profile_picture") String profile_picture,
                                            @RequestPart ("gender") String gender,
                                            @RequestPart ("status") String status,
                                            @RequestPart ("designation") String designation,
                                            @RequestPart ("access_role") String access_role,
                                            @RequestPart ("dob") String dob,
                                            @RequestPart ("attached_branch") String attached_branch,
                                            @RequestPart ("address_line_01") String address_line_01,
                                            @RequestPart ("address_line_02") String address_line_02,
                                            @RequestPart ("address_line_03") String address_line_03,
                                            @RequestPart ("address_line_04") String address_line_04,
                                            @RequestPart ("postalCode") String postalCode,
                                            @RequestPart ("contact_no") String contact_no,
                                            @RequestPart ("email") String email,
                                            @RequestPart ("name_of_the_guardian") String name_of_the_guardian,
                                            @RequestPart ("emergency_contact_no") String emergency_contact_no,
                                            Errors errors ){
        if (errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployee_name(employee_name);
        employeeDTO.setProfile_picture(UtilMatters.convertToBase64(profile_picture));
        employeeDTO.setGender(Gender.valueOf(gender));
        employeeDTO.setStatus(Status.valueOf(status));
        employeeDTO.setDesignation(designation);
        employeeDTO.setAccess_role(Role.valueOf(access_role));
        employeeDTO.setDob(dob);
        employeeDTO.setAttached_branch(attached_branch);
        employeeDTO.setAddress_line_01(address_line_01);
        employeeDTO.setAddress_line_02(address_line_02);
        employeeDTO.setAddress_line_03(address_line_03);
        employeeDTO.setAddress_line_04(address_line_04);
        employeeDTO.setPostalCode(postalCode);
        employeeDTO.setContact_no(contact_no);
        employeeDTO.setEmail(email);
        employeeDTO.setName_of_the_guardian(name_of_the_guardian);
        employeeDTO.setEmergency_contact_no(emergency_contact_no);

        employeeService.updateEmployee(id,employeeDTO);

    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteEmployee(@PathVariable ("id") String id){
        return employeeService.deleteEmployee(id);
    }
}
