package lk.ijse.helloshoesbackend.dto;

import jakarta.validation.constraints.*;
import lk.ijse.helloshoesbackend.Enum.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierDTO implements SuperDTO{

    @Null(message = "Supplier Code generate by the program")
    private String supplierCode;

    @NotBlank(message = "Supplier Name cannot be Blank")
    private String supplier_name;

    @NotNull(message = "Category cannot be Null")
    private Category category;

    @NotBlank(message = "Address line 01 cannot be blank")
    private String address_line_01;

    @NotBlank(message = "Address line 02 cannot be blank")
    private String address_line_02;

    @NotBlank(message = "Address line 03 cannot be blank")
    private String address_line_03;

    @NotBlank(message = "Address line 04 cannot be blank")
    private String address_line_04;

    @NotBlank(message = "Address line 05 cannot be blank")
    private String address_line_05;

    @NotBlank(message = "Address line 06 cannot be blank")
    private String address_line_06;

    @NotBlank(message = "Contact No 01 cannot be blank")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contact_no_01;

    @NotBlank(message = "Contact No 02 cannot be blank")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contact_no_02;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;
}
