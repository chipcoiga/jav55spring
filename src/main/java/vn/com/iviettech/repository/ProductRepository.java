package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.*;

public interface ProductRepository extends JpaRepository<Product, Long> {}