package vn.com.iviettech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.iviettech.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void printSomething() {
        repository.printSomething();
    }
}
