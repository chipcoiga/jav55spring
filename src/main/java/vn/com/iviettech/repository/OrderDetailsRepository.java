package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.OrderDetails;


public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
