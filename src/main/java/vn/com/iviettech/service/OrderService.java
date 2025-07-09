package vn.com.iviettech.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.*;
import vn.com.iviettech.repository.*;

import java.time.LocalDate;
import java.util.Map;

@Service
public class OrderService {

    @Autowired private OrderRepository orderRepo;
    @Autowired private OrderDetailRepository orderDetailRepo;
    @Autowired private ProductRepository productRepo;

    @Transactional
    public void checkout(String name, String address, Map<Long, Integer> items) {
        Orders order = new Orders();
        order.setCustomerName(name);
        order.setAddress(address);
        order.setOrderDate(LocalDate.now());

        for (Map.Entry<Long, Integer> entry : items.entrySet()) {
            Product product = productRepo.findById(entry.getKey()).orElse(null);
            if (product == null) continue;

            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(product);
            detail.setQuantity(entry.getValue());

            order.getOrderDetails().add(detail);
        }

        orderRepo.save(order);
    }
}
