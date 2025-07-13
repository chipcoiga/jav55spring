package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.*;
import vn.com.iviettech.repository.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class OrderService {
    public final OrderRepository orderRepository;
    public final OrderDetailsRepository orderDetailsRepository;
    public final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, OrderDetailsRepository orderDetailsRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailsRepository = orderDetailsRepository;
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void insertSampleOrder() {
//        ProductEntity product = productRepository.findAll().stream().findFirst().orElse(null);
//        if (product == null) {
//            System.out.println("Không có sản phẩm nào để tạo đơn hàng.");
//            return;
//        }
//
//        OrderEntity order = new OrderEntity();
//        order.setOrderDate(LocalDate.now());
//        order.setCustomerName("Nguyễn Văn A");
//        order.setName("Đơn hàng mẫu");
//
//        OrderEntity savedOrder = orderRepository.save(order);
//
//        OrderDetailsEntity detail = new OrderDetailsEntity();
//        detail.setOrder(savedOrder);
//        detail.setProduct(product);
//        detail.setQuantity(2);
//
//        orderDetailsRepository.save(detail);
//    }
//
//    public OrderEntity createOrder() {
//        OrderEntity entity = new OrderEntity();
//        return orderRepository.save(entity);
//    }
//
//    public List<OrderEntity> getOrder(Integer orderID) {
//        return orderID == null
//                ? orderRepository.findAll()
//                : orderRepository.findById(orderID).map(Collections::singletonList).orElse(Collections.emptyList());
    }
}
