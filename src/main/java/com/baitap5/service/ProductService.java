package com.baitap5.service;

import com.baitap5.model.Product;
import com.baitap5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Lấy tất cả sản phẩm
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    // Lấy sản phẩm theo ID
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Thêm hoặc cập nhật sản phẩm
    public Product save(Product product) {
        return productRepository.save(product);
    }

    // Xóa sản phẩm theo ID
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    //Lấy danh sách sản phẩm theo ID danh mục
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
}
