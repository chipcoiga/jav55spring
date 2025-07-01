package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.iviettech.entity.OrderDetailEntity;
import vn.com.iviettech.entity.OrderEntity;
import vn.com.iviettech.repository.OrderDetailRepository;
import vn.com.iviettech.repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository detailRepository;

    public OrderService(OrderRepository orderRepository,
                        OrderDetailRepository detailRepository) {
        this.orderRepository = orderRepository;
        this.detailRepository = detailRepository;
    }

    public List<OrderEntity> getOrdersThisMonth() {
        LocalDate now = LocalDate.now();
        LocalDate start = now.withDayOfMonth(1);
        LocalDate end = now.withDayOfMonth(now.lengthOfMonth());
        return orderRepository.findOrdersInDateRange(start, end);
    }

    @Transactional
    @PostConstruct
    public void init() {
        // Tạo đơn hàng mới
        OrderEntity order = new OrderEntity();
        order.setBuyerName("Truong");
        order.setBuyerPhone("099999999");
        order.setOrderDate(LocalDate.now()); // nhớ set ngày
        orderRepository.save(order);

        // Thêm chi tiết đơn hàng
        OrderDetailEntity detail1 = new OrderDetailEntity();
        detail1.setOrder(order);
        detail1.setProductName("Banh my 45Kg");
        detail1.setQuantity(2);
        detail1.setPrice(3000000);
        detailRepository.save(detail1);

        OrderDetailEntity detail2 = new OrderDetailEntity();
        detail2.setOrder(order);
        detail2.setProductName("Banh my que");
        detail2.setQuantity(3);
        detail2.setPrice(10000);
        detailRepository.save(detail2);

        OrderEntity entity = orderRepository.findById(order.getId()).get();
        System.out.println("===> ĐƠN HÀNG: " + entity.getBuyerName() + " - " + entity.getBuyerPhone());
        for (OrderDetailEntity detail : entity.getOrderDetails()) {
            System.out.println("  -> " + detail.getProductName() + " x" + detail.getQuantity() + " = " + detail.getPrice());
        }

        OrderDetailEntity detail = detailRepository.findById(detail1.getId()).get();
        System.out.println("===> SẢN PHẨM: " + detail.getProductName());
        System.out.println("    Từ đơn hàng: " + detail.getOrder().getBuyerName());
    }
}
