package vn.com.iviettech.Bai5;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class InitData {
    private final OrderService service;
    private final ProductService productService;

    public InitData(OrderService service, ProductService productService) {
        this.service = service;
        this.productService = productService;
    }
    @PostConstruct
    public void init() {
        createOrderWithOrderDetail();
    }

    public Order createOrderWithOrderDetail(){
        Order order = new Order();

        order.setOrderDate(LocalDate.now());
        order.setCustomerAddress("Da Nang");
        order.setCustomerName("Son");

        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail();

        orderDetail1.setQuantity(2);
        orderDetail1.setOrder(order);
        orderDetails.add(orderDetail1);
        OrderDetail orderDetail2 = new OrderDetail();

        orderDetail2.setQuantity(2);
        orderDetail2.setOrder(order);
        orderDetails.add(orderDetail2);
        order.setOrderDetails(orderDetails);
        orderDetail1.setOrder(order);
        orderDetail2.setOrder(order);
        return service.createOrderWithOrderDetail(order, orderDetails);

    }


}
