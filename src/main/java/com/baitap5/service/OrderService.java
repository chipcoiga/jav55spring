package com.baitap5.service;

import com.baitap5.model.Order;
import com.baitap5.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    // Lấy 1 đơn hàng theo ID
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    // Tạo mới 1 đơn hàng
    public Order createOrder(Order order) {
        // Nếu có danh sách chi tiết đơn hàng kèm theo
        if (order.getOrderDetails() != null) {
            // Với mỗi OrderDetails, set lại Order là chính Order đang tạo này
            order.getOrderDetails().forEach(detail -> detail.setOrder(order));
        }
        return orderRepository.save(order); // Cascade sẽ tự động lưu luôn OrderDetails
    }


    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
