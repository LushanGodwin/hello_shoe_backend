package lk.ijse.helloshoesbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO implements SuperDTO{
    @NotBlank(message = "Item code is required")
    private String item_code;

    @NotBlank(message = "Order number is required")
    private String order_number;

    private String customer_code;

    @NotBlank(message = "Item description is required")
    private String item_description;

    @Positive(message = "Size must be a positive integer")
    private Integer size;

    @PositiveOrZero(message = "Unit price must be a positive number")
    private double unit_price;

    @Positive(message = "Item quantity must be a positive integer")
    private Integer item_qty;

    @PositiveOrZero(message = "Total price must be a positive number")
    private double total_price;

    @NotNull(message = "Purchase date is required")
    private Date purchase_date;

    @NotBlank(message = "Payment method is required")
    private String payment_method;

    @PositiveOrZero(message = "Added points must be a positive number")
    private double added_points;

    @NotBlank(message = "Cashier name is required")
    private String cashier_name;
}
