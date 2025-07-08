package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.Product;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long>  {
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByQuantityGreaterThan(int quantity);
}
