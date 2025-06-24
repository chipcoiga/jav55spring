package vn.com.iviettech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.com.iviettech.repository.UserRepository;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void printSomething() {
        System.out.println("Print form service");
        repository.printSomething();
        /// business logic / xử lý tính năng theo requirement
    }
}
