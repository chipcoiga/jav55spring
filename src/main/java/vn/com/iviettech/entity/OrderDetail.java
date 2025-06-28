package vn.com.iviettech.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "orderDetails")
public class OrderDetail {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;
    private int quantity;
    private double unitPrice;

    @ManyToOne
    @JoinColumn (name = "order_id")
    private Orders order;

    public Integer getId ( ) {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public String getProductName ( ) {
        return productName;
    }

    public void setProductName ( String productName ) {
        this.productName = productName;
    }

    public int getQuantity ( ) {
        return quantity;
    }

    public void setQuantity ( int quantity ) {
        this.quantity = quantity;
    }

    public double getUnitPrice ( ) {
        return unitPrice;
    }

    public void setUnitPrice ( double unitPrice ) {
        this.unitPrice = unitPrice;
    }

    public Orders getOrder ( ) {
        return order;
    }

    public void setOrder ( Orders order ) {
        this.order = order;
    }
}
