package vn.com.iviettech.service;

import org.springframework.stereotype.Service;
import vn.com.iviettech.domain.User;
import vn.com.iviettech.entity.UserEntity;
import vn.com.iviettech.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return false;
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            return false;
        }

        UserEntity userEntity = new UserEntity(
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        );

        userRepository.save(userEntity);
        return true;
    }

    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean validatePasswordMatch(String password, String rePassword) {
        return password != null && password.equals(rePassword);
    }

    public boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}