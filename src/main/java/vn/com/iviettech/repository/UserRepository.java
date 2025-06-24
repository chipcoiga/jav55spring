package vn.com.iviettech.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;
import vn.com.iviettech.domain.Account;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public void printSomething() {
        System.out.println("Print from Repository");
    }

    private List<Account> accountList;

    public List<Account> getAccountList(){
        return accountList;
    }

    @PostConstruct
    public void initData() {
        accountList = new ArrayList<>();
        accountList.add(new Account(01, "Lê Thành Đạt"));
        accountList.add(new Account(02, "Trần Thành A"));
        accountList.add(new Account(03, "Lê Nguyễn Ngọc B"));
        accountList.add(new Account(04, "Lê Văn Ng"));

        //Luu vao db.l
    }

    @PreDestroy
    public void preDestroyed() {
        //Luu gio hang vao DB
    }
}
