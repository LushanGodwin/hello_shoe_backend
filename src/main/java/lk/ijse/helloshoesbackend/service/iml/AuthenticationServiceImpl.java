package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.UserDTO;
import lk.ijse.helloshoesbackend.entity.UserEntity;
import lk.ijse.helloshoesbackend.secureAndResponse.response.JwtAuthResponse;
import lk.ijse.helloshoesbackend.secureAndResponse.secure.SignIn;
import lk.ijse.helloshoesbackend.secureAndResponse.secure.SignUp;
import lk.ijse.helloshoesbackend.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import lk.ijse.helloshoesbackend.service.JwtService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lk.ijse.helloshoesbackend.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final Mapping mapping;
    private final UserDao userDao;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        UserDTO userDTO = UserDTO.builder()
                .id(UUID.randomUUID().toString())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(signUp.getRole())
                .build();
        UserEntity saveUser = userDao.save(mapping.toUserEntity(userDTO));
        String generateToken = jwtService.generateToken(saveUser);
        return JwtAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword())
        );
        UserEntity user = userDao.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generateToken = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JwtAuthResponse refreshToken(String refreshToken) {
        var userEntity = userDao
                .findByEmail(jwtService.extractUserName(refreshToken))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return JwtAuthResponse.builder().
                token(jwtService.generateToken(userEntity)).build();
    }
}
