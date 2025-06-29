package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.iviettech.entity.OrderDetailEntity;
import vn.com.iviettech.entity.OrderEntity;
import vn.com.iviettech.repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // 1. Lưu đơn hàng mới
    public OrderEntity saveOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    // 2. Lấy tất cả đơn hàng
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    // 3. Lấy đơn hàng theo ID
    public Optional<OrderEntity> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    // 4. Đơn hàng trong tháng hiện tại
    public List<OrderEntity> getOrdersInCurrentMonth() {
        return orderRepository.findOrdersInCurrentMonth();
    }

    // 5. Đơn hàng có tổng tiền > 1000
    public List<OrderEntity> getOrdersWithTotalAmountGreaterThan1000() {
        return orderRepository.findOrdersWithTotalAmountGreaterThan(1000.0);
    }

    // 6. Đơn hàng có sách Java
    public List<OrderEntity> getOrdersBuyingJavaBook() {
        return orderRepository.findOrdersByProductNameContainingIgnoreCase("java");
    }

    // 7. In tất cả kết quả sau khi thêm dữ liệu mẫu
    @PostConstruct
    public void initSampleData() {

//        OrderEntity order1 = new OrderEntity("Truong", "truong@example.com");
//        order1.addOrderDetail(new OrderDetailEntity("Tiên hiệp", 2, 50.0));
//        order1.addOrderDetail(new OrderDetailEntity("Thư viện kiếm", 1, 80.0));
//        saveOrder(order1);
//
//        OrderEntity order2 = new OrderEntity("Quan", "nguyen@example.com");
//        order2.addOrderDetail(new OrderDetailEntity("Clean Code", 1, 150.0));
//        saveOrder(order2);
//
//        OrderEntity order3 = new OrderEntity("Dat", "datka@example.com");
//        order3.addOrderDetail(new OrderDetailEntity("Java Backend Book", 5, 300.0));
//        saveOrder(order3);
//        OrderEntity order = new OrderEntity("Data", "datka@example.com");
//        order.addOrderDetail(new OrderDetailEntity("Java Backend Book", 5, 15846577));
//        saveOrder(order);



//        getAllOrders().forEach(order -> {
//            System.out.println("Order: " + order.getOrderId() + ", Customer: "
//                    + order.getCustomerName() + ", Email: " + order.getCustomerEmail());
//            order.getOrderDetails().forEach(detail ->
//                    System.out.println("  - Product: " + detail.getProductName()
//                            + ", Quantity: " + detail.getQuantity() + ", Unit Price: "
//                            + detail.getPrice()));
//            System.out.println("  Tổng tiền: " + order.getTotalAmount());
//        });

        //  ID
//        Long sampleId = order1.getOrderId();
//        System.out.println(" Lấy đơn hàng theo ID = " + sampleId + " ===");
//        getOrderById(sampleId).ifPresent(order -> {
//            System.out.println("Order: " + order.getCustomerName()
//                    + ", Email: " + order.getCustomerEmail());
//            System.out.println("Total amount: "
//                    + order.getTotalAmount());
//        });

        // motdh
//        System.out.println(" Đơn hàng trong tháng hiện tại ("
//                + LocalDate.now().getMonth() + ") ===");
//        getOrdersInCurrentMonth().forEach(order ->
//                System.out.println("Order ID: "
//                        + order.getOrderId() + ", Customer: "
//                        + order.getCustomerName()));

        //  có tổng tiền > 1000
//        System.out.println(" Đơn hàng có tổng tiền > 1000 ===");
//        getOrdersWithTotalAmountGreaterThan1000().forEach(order ->
//                System.out.println("Order ID: "
//                        + order.getOrderId() + ", Total: "
//                        + order.getTotalAmount()));
//
        // Đơn hàng mua sách Java
        System.out.println("Đơn hàng có sản phẩm chứa 'Java' ===");
        getOrdersBuyingJavaBook().forEach(order -> {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer: " + order.getCustomerName());
        });
    }
}
