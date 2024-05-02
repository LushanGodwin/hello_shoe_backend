package lk.ijse.helloshoesbackend.dto;

import jakarta.validation.constraints.*;
import lk.ijse.helloshoesbackend.Enum.Gender;
import lk.ijse.helloshoesbackend.Enum.Role;
import lk.ijse.helloshoesbackend.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements SuperDTO{

    @Null(message = "Employee code generate by the program")
    private String employeeCode;

    @NotBlank(message = "Employee name cannot be blank")
    private String employee_name;

    @NotBlank(message = "Profile picture  cannot be blank")
    private String profile_picture;

    @NotNull(message = "Gender cannot be null")
    private Gender gender;

    @NotNull(message = "Status cannot be null")
    private Status status;

    @NotNull(message = "Designation cannot be null")
    private String designation;

    @NotNull(message = "Role cannot be null")
    private Role access_role;

    @Past(message = "Date of birth should be in the past")
    @NotNull(message = "Date of birth cannot be null")
    private String dob;

    @NotBlank(message = "Attached Branch cannot be blank")
    private String attached_branch;

    @NotBlank(message = "Address 1 cannot be blank")
    private String address_line_01;

    @NotBlank(message = "Address 2 cannot be blank")
    private String address_line_02;

    @NotBlank(message = "Address 3 cannot be blank")
    private String address_line_03;

    @NotBlank(message = "Address 4 cannot be blank")
    private String address_line_04;

    @NotBlank(message = "Postal code cannot be blank")
    @Pattern(regexp = "\\d{5}", message = "Postal code must be 5 digits")
    private String postalCode;

    @NotBlank(message = "Contact No cannot be blank")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contact_no;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Emergency Contact Name cannot be blank")
    private String name_of_the_guardian;

    @NotBlank(message = "Emergency Contact No cannot be blank")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid Emergency contact number format")
    private String emergency_contact_no;

}
