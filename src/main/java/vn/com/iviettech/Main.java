package vn.com.iviettech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import vn.com.iviettech.domain.exception.DemoException;
import vn.com.iviettech.service.AccountService;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws DemoException {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        
        AccountService accountService = context.getBean(AccountService.class);
        accountService.initData();
    }
}
