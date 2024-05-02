package lk.ijse.helloshoesbackend.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoesbackend.Enum.Gender;
import lk.ijse.helloshoesbackend.Enum.Role;
import lk.ijse.helloshoesbackend.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    private String employeeCode;
    private String employee_name;
    @Column(columnDefinition = "LONGTEXT")
    private String profile_picture;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String designation;
    @Enumerated(EnumType.STRING)
    private Role access_role;
    private String dob;
    private String attached_branch;
    private String address_line_01;
    private String address_line_02;
    private String address_line_03;
    private String address_line_04;
    private String postalCode;
    private String contact_no;
    private String email;
    private String name_of_the_guardian;
    private String emergency_contact_no;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;

}
