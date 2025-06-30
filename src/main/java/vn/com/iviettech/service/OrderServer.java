package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.iviettech.entity.OrderDetailsEntity;
import vn.com.iviettech.entity.OrdersEntity;
import vn.com.iviettech.repository.OrderRepository;
import vn.com.iviettech.repository.OrderdetailRepository;

import java.util.List;

@Service

public class OrderServer {
    private final OrderRepository orderRepository;
    private final OrderdetailRepository orderdetailRepository;
    public OrderServer(OrderRepository orderRepository, OrderdetailRepository orderdetailRepository) {
        this.orderRepository = orderRepository;
        this.orderdetailRepository = orderdetailRepository;
    }

    @Transactional
    @PostConstruct
    public void init(){
//        OrdersEntity orders =new OrdersEntity();
//        orders.setOrderDate(new Date());
//        orders.setCustomerName("Đạt");
//        orders.setCustomerAddress("Đà Nẵng");
//        orderRepository.save(orders);
//
//        OrderDetailsEntity orderDetailsEntity1 = new OrderDetailsEntity();
//        orderDetailsEntity1.setOrder(orders);
//        orderDetailsEntity1.setProductName("Xe may");
//        orderDetailsEntity1.setQuantity(1);
//        orderDetailsEntity1.setUnitPrice(12000000);
//        orderdetailRepository.save(orderDetailsEntity1);
//
//        OrderDetailsEntity orderDetailsEntity2 = new OrderDetailsEntity();
//        orderDetailsEntity2.setOrder(orders);
//        orderDetailsEntity2.setProductName("Xe moto");
//        orderDetailsEntity2.setQuantity(1);
//        orderDetailsEntity2.setUnitPrice(1200000000);
//        orderdetailRepository.save(orderDetailsEntity2);

        searchExamples();

    }
    public void searchExamples() {
        List<OrdersEntity> orders = orderRepository.findByCustomerNameContainingIgnoreCase("Đạt");
        for (OrdersEntity order : orders) {
            System.out.println("Customer: " + order.getCustomerName() + " - Date: " + order.getOrderDate());
        }

        List<OrderDetailsEntity> orderDetails = orderdetailRepository.findByProductNameContainingIgnoreCase("Xe");
        for (OrderDetailsEntity detail : orderDetails) {
            System.out.println("Product: " + detail.getProductName() + ", Price: " + detail.getUnitPrice());
        }
    }
}
