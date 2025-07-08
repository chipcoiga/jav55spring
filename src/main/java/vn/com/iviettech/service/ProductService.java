package vn.com.iviettech.service;


import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.Product;
import vn.com.iviettech.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Product> getAvailableProducts() {
        return productRepository.findByQuantityGreaterThan(0);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
