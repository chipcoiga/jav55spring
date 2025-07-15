package vn.com.iviettech.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import vn.com.iviettech.entity.UserEntity;
import vn.com.iviettech.repository.UserRepository;

import java.util.List;

@Component
public class CustomUserService implements UserDetailsService {

    private final UserRepository repository;

    public CustomUserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy user: " + username));
        // Chuyển đổi Set<Role> thành Collection<GrantedAuthority>
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
             user.getPasswordHash(),
             true,
             true,
             true,
             true,
             authorities
        );
    }
}
