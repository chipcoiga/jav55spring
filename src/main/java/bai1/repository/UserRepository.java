package bai1.repository;

import bai1.domain.Account;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<Account> accounts = new ArrayList<>();

    public void printSomething() {
        System.out.println("Print from Repository");
    }

    @PostConstruct
    public void initData() {
        Account acc1 = new Account();
        acc1.setName("Nguyen Van A");

        Account acc2 = new Account();
        acc2.setName("Tran Thi B");

        Account acc3 = new Account();
        acc3.setName("Le Van C");

        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);

        System.out.println("Initialized accounts:");
        accounts.forEach(acc -> System.out.println(acc.getName()));
    }

    @PreDestroy
    public void preDestroyed() {
        System.out.println("Saving accounts to DB before shutdown...");
        accounts.forEach(acc -> System.out.println("Saving: " + acc.getName()));
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }
}
