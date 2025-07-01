package com.baitap5.service;

import com.baitap5.model.OrderDetails;
import com.baitap5.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public List<OrderDetails> getAll() {
        return orderDetailsRepository.findAll();
    }

    public OrderDetails getById(Long id) {
        return orderDetailsRepository.findById(id).orElse(null);
    }

    public OrderDetails save(OrderDetails details) {
        return orderDetailsRepository.save(details);
    }

    public void delete(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}
