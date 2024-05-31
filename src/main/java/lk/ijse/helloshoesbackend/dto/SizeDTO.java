package lk.ijse.helloshoesbackend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SizeDTO {
    @NotNull(message = "Size code should not null")
    private String sizeCode;
    @NotNull(message = "Size Description Should not null")
    private String sizeDesc;
}
