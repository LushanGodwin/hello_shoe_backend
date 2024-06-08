package lk.ijse.helloshoesbackend.service.iml;

import lk.ijse.helloshoesbackend.repository.UserDao;
import lk.ijse.helloshoesbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userServiceDao;
    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userServiceDao.findByEmail(username)
                        .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
