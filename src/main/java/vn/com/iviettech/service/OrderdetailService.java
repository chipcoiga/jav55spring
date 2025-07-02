package vn.com.iviettech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.OrderDetail;
import vn.com.iviettech.repository.OrderDetailRepository;

import java.util.List;

@Service
public class OrderdetailService {

    @Autowired
    private OrderDetailRepository orderDetailsRepository;

    public List<OrderDetail> getAll() {
        return orderDetailsRepository.findAll();
    }

    public OrderDetail getById(Long id) {
        return orderDetailsRepository.findById(id).orElse(null);
    }

    public OrderDetail save(OrderDetail details) {
        return orderDetailsRepository.save(details);
    }

    public void delete(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}
