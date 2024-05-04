package lk.ijse.helloshoesbackend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VarietyDTO implements SuperDTO{
    @NotNull(message="variety code not be null")
    private String varietyCode;
    @NotNull(message="variety desc not be null")
    private String varietyDesc;
}
