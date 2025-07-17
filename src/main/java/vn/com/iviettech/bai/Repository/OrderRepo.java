package vn.com.iviettech.bai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.iviettech.bai.Entity.Product;

@Repository
public interface OrderRepo extends JpaRepository<Product, Long> {
}
