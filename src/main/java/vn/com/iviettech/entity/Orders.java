package vn.com.iviettech.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table (name = "orders")
public class Orders {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date orderDate;
    private String customerName;
    private String customerAddress;

    @OneToMany (fetch = FetchType.EAGER, mappedBy = "order")
    private List<OrderDetail> orderDetails;

    public Integer getId ( ) {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public Date getOrderDate ( ) {
        return orderDate;
    }

    public void setOrderDate ( Date orderDate ) {
        this.orderDate = orderDate;
    }

    public String getCustomerName ( ) {
        return customerName;
    }

    public void setCustomerName ( String customerName ) {
        this.customerName = customerName;
    }

    public String getCustomerAddress ( ) {
        return customerAddress;
    }

    public void setCustomerAddress ( String customerAddress ) {
        this.customerAddress = customerAddress;
    }

    public List<OrderDetail> getOrderDetails ( ) {
        return orderDetails;
    }

    public void setOrderDetails ( List<OrderDetail> orderDetails ) {
        this.orderDetails = orderDetails;
    }
}
