package vn.com.iviettech.Bai3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment2Main {
    public static void main(String[] args) {
        var context = SpringApplication.run(Assignment2Main.class, args);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.inputOrder();
        orderService.printAllOrdersWithLines();
    }
}
