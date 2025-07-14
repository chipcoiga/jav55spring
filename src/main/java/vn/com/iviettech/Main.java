package vn.com.iviettech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import vn.com.iviettech.domain.exception.DemoException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws DemoException {
//        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
//
//        AccountService accountService = context.getBean(AccountService.class);
//        accountService.initData();
        SpringApplication.run(Main.class, args);
    }
}
