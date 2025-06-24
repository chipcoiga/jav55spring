package vn.com.iviettech.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;
import vn.com.iviettech.domain.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {

    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    @PostConstruct
    public void initData() {
        Account account1 = new Account();
        account1.setName("Nguyen Van Nguyen");
        account1.setId(1);

        Account account2 = new Account();
        account2.setName("Le Van Truong");
        account2.setId(2);

        Account account3 = new Account();
        account3.setName("Le Van Dat");
        account3.setId(3);

        Account account4 = new Account();
        account4.setName("Truong Van Da");
        account4.setId(4);

        accounts.addAll(Arrays.asList(account1, account2, account3, account4));
    }

    @PreDestroy
    public void preDestroyed() {
        //Luu gio hang vao DB
    }
}
