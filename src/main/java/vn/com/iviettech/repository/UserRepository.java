package vn.com.iviettech.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;
import vn.com.iviettech.domain.Account;

@Repository
public class UserRepository {

    public void printSomething() {
        System.out.println("Print from Repository");
    }

    @PostConstruct
    public void initData() {
        Account account = new Account();
        account.setName("sdfdsf");

        //Luu vao db
    }

    @PreDestroy
    public void preDestroyed() {
        //Luu gio hang vao DB
    }
}
