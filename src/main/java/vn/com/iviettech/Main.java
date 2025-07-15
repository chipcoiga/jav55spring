package vn.com.iviettech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vn.com.iviettech.domain.exception.DemoException;
import vn.com.iviettech.service.AccountService;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws DemoException {
//        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
//
//        AccountService accountService = context.getBean(AccountService.class);
//        accountService.initData();
        String password = new BCryptPasswordEncoder().encode("qwertyuiop");
        System.out.println(password);
        SpringApplication.run(Main.class, args);
    }
    //$2a$10$nsZRmFfuSLExDN64y5BDKOlwbVv3HR8gBx1PqCjHyEiQsIuuJufvS
    //$2a$10$rBIURgTyL9cL0.t1hyN6S.6QhYNJtcP1ApPoTsRNZ8QepJ43iMrBe
}
