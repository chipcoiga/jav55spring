package vn.com.iviettech.service;

import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.OrderEntity;
import vn.com.iviettech.repository.OrderDetailsRepository;
import vn.com.iviettech.repository.OrderRepository;
import vn.com.iviettech.repository.ProductRepository;

import java.util.List;

@Service

public class OrderService {
    public final OrderRepository orderRepository;
    public final OrderDetailsRepository orderDetailsRepository;
    public final ProductRepository productRepository ;

    public OrderService(OrderRepository orderRepository, OrderDetailsRepository orderDetailsRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailsRepository = orderDetailsRepository;
        this.productRepository = productRepository;
    }

    public List<OrderEntity> getOrder(Long orderID){

        return orderRepository.findByID(orderID);
    }
    public OrderEntity createOrder(){
        OrderEntity entity = new OrderEntity();
        return orderRepository.save(entity);
    }


}
