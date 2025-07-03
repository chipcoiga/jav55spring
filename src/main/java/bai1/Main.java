package bai1;

import bai1.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Quan trọng: dùng annotation này
public class Main implements CommandLineRunner {

    private final UserService userService;

    public Main(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        userService.printSomething();
        userService.printAccounts();
    }
}
