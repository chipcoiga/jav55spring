package vn.com.iviettech.service;

import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.ProductEntity;
import vn.com.iviettech.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}//.

