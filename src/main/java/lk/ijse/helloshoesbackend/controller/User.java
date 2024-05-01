package lk.ijse.helloshoesbackend.controller;
import lk.ijse.helloshoesbackend.service.AuthenticationService;

import lk.ijse.helloshoesbackend.secureAndResponse.response.JwtAuthResponse;
import lk.ijse.helloshoesbackend.secureAndResponse.secure.SignIn;
import lk.ijse.helloshoesbackend.secureAndResponse.secure.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class User {
    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signup){
        return ResponseEntity.ok(authenticationService.signUp(signup));
    }

    @PostMapping("/signIn")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signIn){
        return ResponseEntity.ok(authenticationService.signIn(signIn));
    }

    @GetMapping("/refresh")
    public ResponseEntity<JwtAuthResponse> refresh(
            @RequestParam ("refreshToken") String refreshToken
    ){
        System.out.println(refreshToken);
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }
}
