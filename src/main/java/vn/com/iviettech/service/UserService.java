package vn.com.iviettech.service;

import org.springframework.stereotype.Service;
import vn.com.iviettech.domain.Account;
import vn.com.iviettech.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void searchName() {
        List<Account> accounts = repository.getAccounts();
        for (Account account : accounts) {
            if (account.getName().toLowerCase().contains("ng")) {
                System.out.println(account.getName());
            }
        }
    }
}
