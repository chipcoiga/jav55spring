package vn.com.iviettech.repository;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;
import vn.com.iviettech.domain.Account;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepository {
    List<Account> accounts = new ArrayList<>();
    public void printSomething() {
        System.out.println("Print from Repository");
    }



    public List<Account> getAccount(){
        return accounts;
    }
    @PostConstruct
    public void initData() {
        Account account = new Account();
        account.setName("Son");
        accounts.add(account);
        Account account1 = new Account();
        account1.setName("Nguyen Hau");
        accounts.add(account1);
        Account account2 = new Account();
        account2.setName("Truong");
        accounts.add(account2);
        Account account3 = new Account();
        account3.setName("Quan");
        accounts.add(account3);


        //Luu vao db
    }

    @PreDestroy
    public void preDestroyed() {
        //Luu gio hang vao DB
    }
}
