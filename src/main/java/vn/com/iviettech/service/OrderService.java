package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.OrderDetail;
import vn.com.iviettech.entity.Orders;
import vn.com.iviettech.repository.OrderDetailRepository;
import vn.com.iviettech.repository.OrderRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public OrderService ( OrderRepository orderRepository, OrderDetailRepository orderDetailRepository ) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public List<Orders> getAllOrders ( ) {
        return orderRepository.findAll();
    }

    @PostConstruct
    public void init ( ) {
        // Câu 3
//        createOrder();

        // Câu 4
//        listAllOrders();

        // Câu 5
//        getOrderById(7);

        // Câu 6
//        listOrdersInCurrentMonth();

        // Câu 7
//        List<OrderDetail> details = orderDetailRepository.findByUnitPriceGreaterThan(1000.0);
//        for (OrderDetail detail : details) {
//            Orders order = detail.getOrder();
//            System.out.println(order.getCustomerName());
//        }

        // Câu 8
        listOrdersBuyJavaBookWithMethod();
    }

    public void createOrder ( ) {
        Orders order1 = new Orders();
        order1.setCustomerName("Nguyen Van D");
        order1.setCustomerAddress("1 Le Duan");
        order1.setOrderDate(new Date());
        orderRepository.save(order1);

        // orderDetail
        OrderDetail detail1 = new OrderDetail();
        detail1.setProductName("Java");
        detail1.setQuantity(23);
        detail1.setUnitPrice(30.0);
        detail1.setOrder(order1);

        OrderDetail detail2 = new OrderDetail();
        detail2.setProductName("Spring Boot");
        detail2.setQuantity(30);
        detail2.setUnitPrice(2000.0);
        detail2.setOrder(order1);

        orderDetailRepository.save(detail1);
        orderDetailRepository.save(detail2);
    }

    public void listAllOrders ( ) {
        List<Orders> orders = orderRepository.findAll();

        System.out.println("Danh sách đơn hàng:");
        for (Orders order : orders) {
            System.out.println("Đơn hàng ID: " + order.getId());
            System.out.println("Tên KH: " + order.getCustomerName());
            System.out.println("Địa chỉ: " + order.getCustomerAddress());
            System.out.println("Ngày đặt: " + order.getOrderDate());

            List<OrderDetail> details = order.getOrderDetails();
            if (details != null && !details.isEmpty()) {
                System.out.println("Chi tiết:");
                for (OrderDetail detail : details) {
                    System.out.println("  - " + detail.getProductName() +
                            ", SL: " + detail.getQuantity() +
                            ", Đơn giá: " + detail.getUnitPrice());
                }
            } else {
                System.out.println("  (Không có chi tiết đơn hàng)");
            }

            System.out.println("==================================");
        }
    }

    public void getOrderById ( int id ) {
        Orders order = orderRepository.findById(id).orElse(null);

        if (order != null) {
            System.out.println("Đơn hàng ID: " + order.getId());
            System.out.println("Tên KH: " + order.getCustomerName());
            System.out.println("Địa chỉ: " + order.getCustomerAddress());
            System.out.println("Ngày đặt: " + order.getOrderDate());

            List<OrderDetail> details = order.getOrderDetails();
            if (details != null && !details.isEmpty()) {
                System.out.println("Chi tiết: ");
                for (OrderDetail detail : details) {
                    System.out.println("  - " + detail.getProductName() +
                            ", SL: " + detail.getQuantity() +
                            ", Đơn giá: " + detail.getUnitPrice());
                }
            } else {
                System.out.println("Đơn hàng không có chi tiết.");
            }
        } else {
            System.out.println("Không tìm thấy đơn hàng với ID = " + id);
        }
    }

    public void listOrdersInCurrentMonth ( ) {
        List<Orders> allOrders = orderRepository.findAll();

        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();

        System.out.println("Đơn hàng trong tháng hiện tại:");

        boolean found = false;

        for (Orders order : allOrders) {
            if (order.getOrderDate() == null) continue;

            LocalDate orderDate = order.getOrderDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            if (orderDate.getMonthValue() == currentMonth) {
                found = true;
                System.out.println("ID: " + order.getId() + " | KH: " + order.getCustomerName() + " | Ngày: " + order.getOrderDate());

                for (OrderDetail detail : order.getOrderDetails()) {
                    System.out.println("  - " + detail.getProductName() +
                            ", SL: " + detail.getQuantity() +
                            ", Giá: " + detail.getUnitPrice());
                }

                System.out.println("-----------------------------------");
            }
        }

        if (!found) {
            System.out.println("Không có đơn hàng nào trong tháng này.");
        }
    }

    public void listOrdersBuyJavaBookWithMethod ( ) {
        List<OrderDetail> javaDetails = orderDetailRepository.findByProductNameContainingIgnoreCase("java book");

        if (javaDetails.isEmpty()) {
            System.out.println("Không có đơn hàng nào mua sách Java.");
            return;
        }

        System.out.println("Danh sách đơn hàng mua sách Java:");

        for (OrderDetail detail : javaDetails) {
            Orders order = detail.getOrder();

            System.out.println("Đơn hàng ID: " + order.getId());
            System.out.println("KH: " + order.getCustomerName());
            System.out.println("Ngày: " + order.getOrderDate());
            System.out.println("Sản phẩm: " + detail.getProductName());
            System.out.println("---------------------------------");
        }
    }
}
