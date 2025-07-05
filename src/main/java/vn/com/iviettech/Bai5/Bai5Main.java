package vn.com.iviettech.Bai5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Bai5Main {
    public static void main(String[] args) {
         SpringApplication.run(Bai5Main.class, args);
//
//        OrderService5 service = context.getBean(OrderService5.class);
//        Order order = new Order();
//        order.setCustomerName("A");
//        order.setOrderDate(LocalDate.of(2025,01,03));
//        order.setCustomerAddress("Da Nang");
//        service.createOrder(order);
//        service.getAllOrders();
//        service.getAllOrders().forEach(System.out::println);
//
//

    }
}
