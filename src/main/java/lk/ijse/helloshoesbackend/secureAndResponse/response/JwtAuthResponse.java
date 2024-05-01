package lk.ijse.helloshoesbackend.secureAndResponse.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class JwtAuthResponse {
    private String token;
}
