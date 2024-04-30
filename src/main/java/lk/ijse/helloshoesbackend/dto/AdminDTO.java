package lk.ijse.helloshoesbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO implements SuperDTO{

    @NotNull(message = "Total Sale cannot be Null")
    private Double totalSales;

    @NotNull(message = "Total Profit cannot be Null")
    private Double totalProfit;

    @NotBlank(message = "Most Sale Item cannot be Null")
    private String mostSaleItem;

    @NotBlank(message = "Picture cannot be Null")
    private String itemPic;

    @NotBlank(message = "Sale Item Qty cannot be Null")
    private Integer saleItemQty;
}
