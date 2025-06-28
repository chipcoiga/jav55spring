package vn.com.iviettech.Bai3;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class OrderLineService {
    Scanner scanner = new Scanner(System.in);


    public OrderLine inputOrderLine(Order order){

            OrderLine orderLine = new OrderLine();
            System.out.println("input orderLine: ");
            System.out.println("id: ");
            Long id = Long.parseLong(scanner.nextLine());
            orderLine.setId(id);
            System.out.println("product name: ");
            String name = scanner.nextLine();
            orderLine.setItems(name);
            System.out.println("quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("price: ");
            double price = Double.parseDouble(scanner.nextLine());
            orderLine.setPrice(price);
            orderLine.setOrder(order);

            return orderLine;
        }

    }


