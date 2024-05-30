package lk.ijse.helloshoesbackend.dto;

import jakarta.validation.constraints.*;
import lk.ijse.helloshoesbackend.Enum.Gender;
import lk.ijse.helloshoesbackend.Enum.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements SuperDTO{

    @Null(message = "Customer Code generate by the program")
    private String customerCode;

    @NotBlank(message = "Customer Name cannot be Blank")
    private String customer_name;

    @NotNull(message = "Gender cannot be Null")
    private Gender gender;

    @PastOrPresent(message = "Join Date must be Present or Past")
    @NotNull(message = "Join date cannot be null")
    private Date joinDate;

    @NotNull(message = "Level cannot be null")
    private Level level;

    @PositiveOrZero(message = "Total Points must be Positive or Zero")
    private Integer totalPoints;

    @Past(message = "DOB must be Past")
    private Date dob;

    @NotBlank(message = "Address line 01 cannot be blank")
    private String address_line_01;

    @NotBlank(message = "Address line 02 cannot be blank")
    private String address_line_02;

    @NotBlank(message = "Address line 03 cannot be blank")
    private String address_line_03;

    @NotBlank(message = "Address line 04 cannot be blank")
    private String address_line_04;

    @NotBlank(message = "PostalCode cannot be blank")
    private String postalCode;

    @NotBlank(message = "Contact No cannot be blank")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contact;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotNull(message = "Purchased date cannot be null")
    private Timestamp purchase_time_date;
}
