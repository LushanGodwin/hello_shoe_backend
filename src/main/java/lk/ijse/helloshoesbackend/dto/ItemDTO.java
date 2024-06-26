package lk.ijse.helloshoesbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO implements SuperDTO{
    @Null(message = "Item code generate by the program")
    private String itemCode;
    @NotBlank(message = "Item Description cannot be blank")
    private String itemDesc;
    @NotNull(message = "Propic cannot be null")
    private String pic;
    /*@NotNull(message = "Status cannot be null")
    private ItemStatus status;
    @NotNull(message = "Category cannot be null")
    private String category;

    @NotNull(message = "Size cannot be null")
    private String size;

    @NotBlank(message = "Supplier code cannot be blank")
    private String supplierCode;

    @NotNull(message = "Unit Price Sale cannot be null.")
    @PositiveOrZero(message = "Unit Price Sale cannot be negative.")
    private Double unitPriceSale;

    @NotNull(message = "Unit Price Buy cannot be null.")
    @PositiveOrZero(message = "Unit Price Buy cannot be negative.")
    private Double unitPriceBuy;

    @NotNull(message = "Expected Profit Sale cannot be null.")
    @PositiveOrZero(message = "Expected Profit Sale cannot be negative.")
    private Double expectedProfit;

    @NotNull(message = "Profit Margin cannot be null.")
    @PositiveOrZero(message = "profit Margin cannot be negative.")
    private Double profitMargin;*/

    private String genderCode;
    private String occasionCode;
    private String varietyCode;
}
