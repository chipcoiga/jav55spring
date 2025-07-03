package vn.com.iviettech.service;

import org.springframework.stereotype.Service;
import vn.com.iviettech.domain.OrderItemDTO;
import vn.com.iviettech.domain.OrderRequestDTO;
import vn.com.iviettech.entity.OrderDetailsEntity;
import vn.com.iviettech.entity.OrderEntity;
import vn.com.iviettech.entity.ProductEntity;
import vn.com.iviettech.repository.OrderDetailsRepository;
import vn.com.iviettech.repository.OrderRepository;
import vn.com.iviettech.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<OrderEntity> getOrder(Long orderID) {
        return orderRepository.findById(orderID);
    }

    public OrderEntity createOrder() {
        OrderEntity entity = new OrderEntity();
        return orderRepository.save(entity);
    }
    public OrderEntity createOrder(OrderRequestDTO dto) {
        OrderEntity order = new OrderEntity();
        order.setName(dto.getName());
        order.setCustomerName(dto.getCustomerName());
        order.setOrderDate(dto.getOrderDate());

        List<OrderDetailsEntity> orderDetailsList = new ArrayList<>();
        for (OrderItemDTO item : dto.getItems()) {
            Optional<ProductEntity> productOpt = productRepository.findById(item.getProductId());
            if (productOpt.isPresent()) {
                OrderDetailsEntity detail = new OrderDetailsEntity();
                detail.setProduct(productOpt.get());
                detail.setQuantity(item.getQuantity());
                detail.setOrder(order);
                orderDetailsList.add(detail);
            }
        }

        order.setOrderDetails(orderDetailsList);

        return orderRepository.save(order);
    }
}
