package vn.com.iviettech.domain;

public class OrderTotalDTO{
    private Integer orderId;
    private String customerName;
    private Double totalAmount;

    public OrderTotalDTO(Integer orderId, String customerName, Double totalAmount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }
}
