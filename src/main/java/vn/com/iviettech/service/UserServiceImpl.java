package vn.com.iviettech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.UserEntity;
import vn.com.iviettech.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public boolean checkLogin(String name, String password) {
        return userRepository.findByNameAndPassword(name, password) != null;
    }
}
