package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.Product;
import vn.com.iviettech.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
//    public void initSampleData() {
//        try {
//            if (productRepository.count() == 0) {
//                System.out.println("Database trống, tạo dữ liệu mẫu...");
//                createSampleProducts();
//                System.out.println("Đã tạo xong dữ liệu mẫu");
//            } else {
//                System.out.println("Database đã có " + productRepository.count() + " sản phẩm");
//            }
//        } catch (Exception e) {
//            System.err.println("Lỗi khi khởi tạo dữ liệu: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }

//    private void createSampleProducts() {
//        try {
//
//            Product product1 = new Product();
//            product1.setProductName("iPhone 15 Pro");
//            product1.setProductDescription("Điện thoại thông minh cao cấp với chip A17 Pro");
//            product1.setUnitPrice(999.99);
//
//            Product product2 = new Product();
//            product2.setProductName("Samsung Galaxy S24");
//            product2.setProductDescription("Smartphone Android flagship với camera AI");
//            product2.setUnitPrice(899.99);
//
//            Product product3 = new Product();
//            product3.setProductName("MacBook Air M2");
//            product3.setProductDescription("Laptop siêu mỏng với chip M2 mạnh mẽ");
//            product3.setUnitPrice(1299.99);
//
//            Product product4 = new Product();
//            product4.setProductName("Sony WH-1000XM5");
//            product4.setProductDescription("Tai nghe không dây chống ồn hàng đầu");
//            product4.setUnitPrice(399.99);
//
//            Product product5 = new Product();
//            product5.setProductName("iPad Pro 12.9");
//            product5.setProductDescription("Máy tính bảng chuyên nghiệp với chip M2");
//            product5.setUnitPrice(1099.99);
//
//            Product product6 = new Product();
//            product6.setProductName("Apple Watch Series 9");
//            product6.setProductDescription("Đồng hồ thông minh với tính năng sức khỏe");
//            product6.setUnitPrice(399.99);
//
//            // Lưu vào database
//            productRepository.save(product1);
//            productRepository.save(product2);
//            productRepository.save(product3);
//            productRepository.save(product4);
//            productRepository.save(product5);
//            productRepository.save(product6);
//
//            System.out.println("Đã tạo 6 sản phẩm mẫu");
//        } catch (Exception e) {
//            System.err.println("Lỗi khi tạo dữ liệu mẫu: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }

    public List<Product> getAllProducts() {
        try {
            List<Product> products = productRepository.findAll();
            System.out.println("Lấy san phẩm dât" + products.size() + " ");
            return products;
        } catch (Exception e) {
            System.err.println("r: " + e.getMessage());
            e.printStackTrace();
            return List.of(); // Trả về list rỗng thay vì null
        }
    }



    // Tạo sản phẩm mới
    public Product createProduct(Product product) {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            System.err.println("Lỗi khi tạo sản phẩm: " + e.getMessage());
            throw e;
        }
    }


    public Product updateProduct(Long id, Product productDetails) {
        try {
            Optional<Product> optionalProduct = productRepository.findById(id);
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                product.setProductName(productDetails.getProductName());
                product.setProductDescription(productDetails.getProductDescription());
                product.setUnitPrice(productDetails.getUnitPrice());
                product.setCategory(productDetails.getCategory());
                return productRepository.save(product);
            }
            return null;
        } catch (Exception e) {
            System.err.println("Lỗi khi cập nhật sản phẩm: " + e.getMessage());
            throw e;
        }
    }

    // Xóa sản phẩm
    public boolean deleteProduct(Long id) {
        try {
            if (productRepository.existsById(id)) {
                productRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("Lỗi khi xóa sản phẩm: " + e.getMessage());
            return false;
        }
    }



    // Tìm sản phẩm theo tên
    public List<Product> findProductsByName(String name) {
        try {
            List<Product> products = productRepository.findAll().stream()
                    .filter(product -> product.getProductName().toLowerCase().contains(name.toLowerCase()))
                    .toList();
            System.out.println("Tìm được " + products.size() + " sản phẩm với từ khóa: " + name);
            return products;
        } catch (Exception e) {
            System.err.println("Lỗi khi tìm kiếm sản phẩm: " + e.getMessage());
            return List.of();
        }
    }


}