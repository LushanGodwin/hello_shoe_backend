package lk.ijse.helloshoesbackend.entity;


import lk.ijse.helloshoesbackend.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class UserEntity implements UserDetails {
    @Id
    private String userId;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private EmployeeEntity employeeEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> autherities = new HashSet<>();
        autherities.add(new SimpleGrantedAuthority("ROLE_"+role.name()));
        return autherities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
