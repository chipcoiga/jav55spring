package vn.com.iviettech.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.com.iviettech.domain.Account;
import vn.com.iviettech.domain.Company;
import vn.com.iviettech.domain.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class RestApiDemo {

    @GetMapping("users/{id}")
    public User getUser(@PathVariable("id") int userId,
                        @RequestParam("email") String email) {
        //call service to get user from database
        User user = new User();
        user.setEmail(email);
        user.setUsername("lhloc" + userId);

        return user;
    }

    @PostMapping("users")
    public void createUser(@RequestBody @Validated User user) {
        System.out.println("user created successful");
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        //Lwu vao database
    }

    @GetMapping("companies")
    public Company getCompany() {
        return createCompanyDemo();
    }


    private Company createCompanyDemo() {
        User user = new User();
        user.setEmail("lhloc@gmail.com");
        user.setUsername("lhloc");

        User user1 = new User();
        user.setEmail("khang@gmail.com");
        user.setUsername("khang");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        Account account = new Account();
        account.setId(1);
        account.setName("Account 1");

        Company company = new Company(
                1, "Company A", users, account
        );

        return company;
    }
}
