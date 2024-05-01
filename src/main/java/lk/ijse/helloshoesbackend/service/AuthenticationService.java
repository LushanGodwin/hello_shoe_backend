package lk.ijse.helloshoesbackend.service;

import lk.ijse.helloshoesbackend.secureAndResponse.response.JwtAuthResponse;
import lk.ijse.helloshoesbackend.secureAndResponse.secure.SignIn;
import lk.ijse.helloshoesbackend.secureAndResponse.secure.SignUp;

public interface AuthenticationService {
    JwtAuthResponse signUp(SignUp signUp);
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse refreshToken(String refreshToken);
}
