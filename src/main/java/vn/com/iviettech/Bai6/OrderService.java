package vn.com.iviettech.Bai6;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id){
        Order order = orderRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        System.out.println(order.getId());
        System.out.println(order.getOrderDate());
        System.out.println(order.getCustomerName());
        System.out.println(order.getCustomerAddress());
        return order;
    }

    public Order createOrderWithOrderDetail(Order order, List<OrderDetail> orderDetails){
        for(OrderDetail o: orderDetails){
            o.setOrder(order);
        }
        order.setOrderDetails(orderDetails);
        return orderRepository.save(order);
    }
    public Order getAllOrderWithOrderDetail(Long id){
        Order order = orderRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        for(OrderDetail orderDetail: order.getOrderDetails()){
            System.out.println(orderDetail.getId());
            System.out.println(orderDetail.getQuantity());
            System.out.println(orderDetail.getOrder());
        }


        return order;

    }
}
