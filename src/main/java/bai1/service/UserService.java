package bai1.service;

import bai1.domain.Account; //
import bai1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void printSomething() {
        System.out.println("Print from service");
        repository.printSomething();
    }

    public void printAccounts() {
        List<Account> accounts = repository.getAllAccounts();
        System.out.println("Danh sách tài khoản:");
        for (Account acc : accounts) {
            System.out.println("- " + acc.getName());
        }
    }
}
