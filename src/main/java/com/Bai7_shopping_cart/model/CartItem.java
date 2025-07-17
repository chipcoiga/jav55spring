package com.Bai7_shopping_cart.model;

public class CartItem {
    private ProductEntity product;
    private int quantity;

    public CartItem(ProductEntity product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getUnitPrice() * quantity;
    }
}
