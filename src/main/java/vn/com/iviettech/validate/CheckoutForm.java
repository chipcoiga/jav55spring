package vn.com.iviettech.validate;

import jakarta.validation.constraints.NotBlank;

public class CheckoutForm {

    @NotBlank(message = "Tên người mua không được để trống")
    private String name;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    // Getters và Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}//.
