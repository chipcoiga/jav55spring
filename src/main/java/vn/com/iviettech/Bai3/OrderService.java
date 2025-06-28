package vn.com.iviettech.Bai3;

import jakarta.annotation.PostConstruct;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class OrderService {
    Scanner scanner = new Scanner(System.in);
    private final OrderRepository orderRepository;
    private final OrderLineService orderLineService;

    public OrderService(OrderRepository orderRepository, OrderLineService orderLineService) {
        this.orderRepository = orderRepository;
        this.orderLineService = orderLineService;
    }
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public void inputOrder(){


            Order order = new Order();
            System.out.println("enter order");
            System.out.println("id: ");
            Long id = Long.parseLong(scanner.nextLine());
            order.setId(id);
            System.out.print("Year: ");
              int year = Integer.parseInt(scanner.nextLine());

            System.out.print("Month: ");
            int month = Integer.parseInt(scanner.nextLine());

            System.out.print("Day: ");
            int day = Integer.parseInt(scanner.nextLine());

            LocalDate date = LocalDate.of(year, month, day);
            order.setCreationDate(date);
            System.out.println("name: ");
            String name = scanner.nextLine();
            order.setCustomerName(name);
            System.out.println("address: ");
            String address = scanner.nextLine();
            order.setCustomerAddress(address);

            System.out.println("numbers of orderList: ");
            int n = Integer.parseInt(scanner.nextLine());
            List<OrderLine> orderLines = new ArrayList<>();
            for(int i = 0; i < n; i++){
                OrderLine orderLine = orderLineService.inputOrderLine(order);
                orderLines.add(orderLine);

            }

            order.setOrderLines(orderLines);
            orderRepository.save(order);

    }

    public void printAllOrdersWithLines() {
        List<Order> orders = orderRepository.findAll();
        for (Order order : orders) {
            System.out.println("\n===== Đơn hàng ID: " + order.getId() + " =====");
            System.out.println("Ngày tạo: " + order.getCreationDate());
            System.out.println("Khách hàng: " + order.getCustomerName());
            System.out.println("Địa chỉ: " + order.getCustomerAddress());

            System.out.println(">>> Danh sách sản phẩm:");
            for (OrderLine line : order.getOrderLines()) {
                System.out.println("- " + line.getItems() + " | SL: " + line.getQuantity() + " | Đơn giá: " + line.getPrice());
            }
        }
    }



}


