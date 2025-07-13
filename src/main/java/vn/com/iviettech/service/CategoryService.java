package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.CategoryEntity;
import vn.com.iviettech.entity.ProductEntity;
import vn.com.iviettech.repository.CategoryRepository;
import vn.com.iviettech.repository.ProductRepository;

import java.util.Arrays;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void insertSampleData() {
//        CategoryEntity category = new CategoryEntity();
//        category.setName("Electronics");
//
//        CategoryEntity savedCategory = categoryRepository.save(category);
//
//        ProductEntity product1 = new ProductEntity();
//        product1.setProductName("iPhone 15");
//        product1.setProductDescription("Apple smartphone");
//        product1.setUnitPrice(30000000L);
//        product1.setCategory(savedCategory);
//
//        ProductEntity product2 = new ProductEntity();
//        product2.setProductName("Samsung Galaxy S24");
//        product2.setProductDescription("Samsung smartphone");
//        product2.setUnitPrice(25000000L);
//        product2.setCategory(savedCategory);
//
//        productRepository.saveAll(Arrays.asList(product1, product2));
    }
}
