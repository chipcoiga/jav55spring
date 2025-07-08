package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
