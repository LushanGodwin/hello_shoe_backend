package lk.ijse.helloshoesbackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenderDTO implements SuperDTO{
    @NotNull(message = "gender code cannot be null")
    private String genderCode;
    @NotNull(message = "genderDesc cannot be null")
    private String gender_desc;
}
