package vn.com.iviettech.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String customerName;
    private String customerEmail;
    private String status;

    private LocalDate orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailEntity> orderDetails = new ArrayList<>();

    public OrderEntity() {
        this.orderDate = LocalDate.now();
        this.status = "NEW";
    }

    public OrderEntity(String customerName, String customerEmail) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.orderDate = LocalDate.now();
        this.status = "NEW";
    }

    public void addOrderDetail(OrderDetailEntity detail) {
        detail.setOrder(this);
        this.orderDetails.add(detail);
    }

    public double getTotalAmount() {
        return orderDetails.stream()
                .mapToDouble(d -> d.getPrice() * d.getQuantity())
                .sum();
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetailEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
