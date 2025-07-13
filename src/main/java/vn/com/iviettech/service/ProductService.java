package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.CategoryEntity;
import vn.com.iviettech.entity.ProductEntity;
import vn.com.iviettech.repository.CategoryRepository;
import vn.com.iviettech.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    public void save(ProductEntity product) {
        productRepository.save(product);
    }

    public ProductEntity getById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @PostConstruct
    public void insertSampleData() {
//        // Tạo Category
//        CategoryEntity category = new CategoryEntity();
//        category.setName("Electronics");
//
//        CategoryEntity savedCategory = categoryRepository.save(category);
//
//        // Tạo danh sách sản phẩm
//        ProductEntity p1 = new ProductEntity();
//        p1.setProductName("MacBook Pro");
//        p1.setProductDescription("Apple laptop");
//        p1.setUnitPrice(50000000L);
//        p1.setCategory(savedCategory);
//
//        ProductEntity p2 = new ProductEntity();
//        p2.setProductName("Dell XPS 15");
//        p2.setProductDescription("High-end Dell laptop");
//        p2.setUnitPrice(40000000L);
//        p2.setCategory(savedCategory);
//
//        productRepository.saveAll(Arrays.asList(p1, p2));
//    }
//
//    public List<ProductEntity> getProductsByCategory(Integer categoryID) {
//        return productRepository.findByCategory_CategoryID(categoryID);
    }
}
