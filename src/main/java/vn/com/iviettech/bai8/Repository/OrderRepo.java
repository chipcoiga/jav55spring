package vn.com.iviettech.bai8.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.iviettech.bai8.Entity.Product;

@Repository
public interface OrderRepo extends JpaRepository<Product, Long> {
}
