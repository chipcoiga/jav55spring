package vn.com.iviettech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    private List<Account> getAcount(){
        return getAcount();
    };
    public void printSomething() {
        System.out.println("Print form service");
        repository.printSomething();
        /// business logic / xử lý tính năng theo requirement
    }

    public void searchName(){
        List<Account> accounts = repository.getAccountList();
        for (Account account : accounts){
            if (account.getName().toLowerCase().contains("ng")){
                System.out.println(account.getName());
            }
        }
    }
    //
}
