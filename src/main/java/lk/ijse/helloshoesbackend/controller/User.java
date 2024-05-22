package lk.ijse.helloshoesbackend.controller;
import lk.ijse.helloshoesbackend.dto.BranchDTO;
import lk.ijse.helloshoesbackend.exception.InvalidException;
import lk.ijse.helloshoesbackend.service.AuthenticationService;

import lk.ijse.helloshoesbackend.secureAndResponse.response.JwtAuthResponse;
import lk.ijse.helloshoesbackend.secureAndResponse.secure.SignIn;
import lk.ijse.helloshoesbackend.secureAndResponse.secure.SignUp;
import lk.ijse.helloshoesbackend.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:63342")
public class User {
    private final AuthenticationService authenticationService;
    private final BranchService branchService;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/branch")
    public ResponseEntity<?> saveBranch(@Validated @RequestBody BranchDTO branchDTO,
                                        BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        try {
            branchService.saveBranch(branchDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("New Branch Added Successfully.");
        } catch (InvalidException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product Code Invalid");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | New Branch Added Unsuccessfully.\nMore Details\n"+exception);
        }
    }
}
