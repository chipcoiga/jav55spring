package vn.com.iviettech.service;

import vn.com.iviettech.entity.UserEntity;

public interface UserService {
    void save(UserEntity user);
    boolean checkLogin(String name, String password);
}
