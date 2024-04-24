package lk.ijse.helloshoesbackend.dto;

import lk.ijse.helloshoesbackend.entity.Gender;
import lk.ijse.helloshoesbackend.entity.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements SuperDTO{
    private String customer_code;
    private String customer_name;
    private Gender gender;
    private Date joinDate;
    private Level level;
    private Integer totalPoints;
    private Date dob;
    private String address_line_01;
    private String address_line_02;
    private String address_line_03;
    private String address_line_04;
    private String address_line_05;
    private String contact;
    private String email;
    private Timestamp purchase_time_date;
}
