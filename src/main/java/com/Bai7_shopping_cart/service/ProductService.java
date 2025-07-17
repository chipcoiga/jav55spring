package com.Bai7_shopping_cart.service;

import com.Bai7_shopping_cart.model.ProductEntity;
import com.Bai7_shopping_cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // ✅ PHẢI CÓ
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity getProductById(int id) {
        return productRepository.findById(id).orElse(null); // ✅ PHẢI CÓ HÀM NÀY
    }
}
