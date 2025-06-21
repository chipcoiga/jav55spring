package vn.com.iviettech.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public void printSomething() {
        System.out.println("Print from Repository");
    }
}
