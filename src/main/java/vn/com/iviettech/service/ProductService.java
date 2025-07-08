package vn.com.iviettech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.ProductEntity;
import vn.com.iviettech.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }


    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
