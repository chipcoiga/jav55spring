package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.iviettech.entity.OrderDetailEntity;
import vn.com.iviettech.entity.OrderEntity;
import vn.com.iviettech.repository.OrderDetailRepository;
import vn.com.iviettech.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository detailRepository;

    public OrderService(OrderRepository orderRepository,
                        OrderDetailRepository detailRepository) {
        this.orderRepository = orderRepository;
        this.detailRepository = detailRepository;
    }

    @Transactional
    @PostConstruct
    public void init() {
//        OrderEntity order = new OrderEntity();
//        order.setBuyerName("Truong");
//        order.setBuyerPhone("099999999");
//        orderRepository.save(order);
//
//        OrderDetailEntity detail1 = new OrderDetailEntity();
//        detail1.setOrder(order);
//        detail1.setProductName("Banh my 45Kg");
//        detail1.setQuantity(2);
//        detail1.setPrice(3000000);
//        detailRepository.save(detail1);
//
//        OrderDetailEntity detail2 = new OrderDetailEntity();
//        detail2.setOrder(order);
//        detail2.setProductName("Banh my que");
//        detail2.setQuantity(3);
//        detail2.setPrice(10000);
//        detailRepository.save(detail2);

        OrderEntity entity = orderRepository.findById(1).get();
        System.out.println(entity.getId());
        System.out.println(entity.getBuyerName());
        System.out.println(entity.getBuyerPhone());
        System.out.println(entity.getOrderDetails().size());
        for (OrderDetailEntity detail : entity.getOrderDetails()) {
            System.out.println("ID: " + detail.getId());
            System.out.println("product name: " + detail.getProductName());
            System.out.println("quantity: " + detail.getQuantity());
            System.out.println("price: " + detail.getPrice());
        }

//        OrderDetailEntity detail = detailRepository.findById(1).get();
//        System.out.println(detail.getProductName());
//        System.out.println("order: " + detail.getOrder().getId());
//        System.out.println("order: " + detail.getOrder().getBuyerName());
//        System.out.println("order: " + detail.getOrder().getBuyerPhone());
    }
}
