package vn.com.iviettech.service;

import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.ProductEntity;
import vn.com.iviettech.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductEntity> getProductsByCategory(Long categoryID) {
        return repository.findByCategory_CategoryID(categoryID);
    }
}
