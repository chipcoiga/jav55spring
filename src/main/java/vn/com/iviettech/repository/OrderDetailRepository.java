package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.OrderDetailEntity;

public interface OrderDetailRepository
        extends JpaRepository<OrderDetailEntity, Integer> {
}
