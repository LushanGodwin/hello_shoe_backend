package lk.ijse.helloshoesbackend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OccasionDTO implements SuperDTO{
    @NotNull(message = "occasion code cannot be null")
    private String occasionCode;
    @NotNull(message = "occasionDesc cannot be null")
    private String occasionDesc;
}
