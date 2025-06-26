package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.OrderEntity;

public interface OrderRepository
        extends JpaRepository<OrderEntity, Integer> {
}
