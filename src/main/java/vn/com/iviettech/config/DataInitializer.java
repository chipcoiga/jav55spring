package vn.com.iviettech.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.com.iviettech.entity.Product;
import vn.com.iviettech.repository.ProductRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    // ✅ Constructor Injection – không cần @Autowired
    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            productRepository.save(new Product(null, 10, 25000000, "Laptop Dell XPS 13"));
            productRepository.save(new Product(null, 15, 30000000, "iPhone 15 Pro"));
            productRepository.save(new Product(null, 20, 22000000, "Samsung Galaxy S24"));
            productRepository.save(new Product(null, 8, 45000000, "MacBook Pro M3"));
            productRepository.save(new Product(null, 25, 8000000, "Sony WH-1000XM5"));

            System.out.println("✅ Dữ liệu mẫu đã được tạo thành công!");
        }
    }
}
