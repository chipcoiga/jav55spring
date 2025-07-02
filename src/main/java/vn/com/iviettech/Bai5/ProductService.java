package vn.com.iviettech.Bai5;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public List<Product> getProductByCategory(Long id) {
        List<Product> products = new ArrayList<>();
        for(Product p: productRepository.findAll()){
            if(p.getCategory()!= null && p.getCategory().getId().equals(id)){
                products.add(p);
            }
        }
        return products;
    }

}