package vn.com.iviettech.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.iviettech.entity.*;
import vn.com.iviettech.repository.OrderDetailsRepository;
import vn.com.iviettech.repository.OrderRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;

    public CartService(OrderRepository orderRepository, OrderDetailsRepository orderDetailsRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Transactional
    public Orders checkout(CartEntity cart, String customerName, String customerAddress) {
        // Create order
        Orders order = new Orders();
        order.setCustomerName(customerName);
        order.setCustomerAddress(customerAddress);
        order.setOrderDate(LocalDate.now());
        order = orderRepository.save(order);

        // Create order details
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        for (CartEntity.CartItem item : cart.getItems()) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrder(order);
            orderDetails.setProduct(item.getProduct());
            orderDetails.setQuantity(item.getQuantity());
            orderDetails.setPrice(item.getProduct().getPrice());
            orderDetailsList.add(orderDetails);
        }

        orderDetailsRepository.saveAll(orderDetailsList);

        // Clear cart after successful checkout
        cart.clear();

        return order;
    }
}
