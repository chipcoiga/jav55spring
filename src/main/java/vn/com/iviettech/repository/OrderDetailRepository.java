package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.OrderDetail;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findByUnitPriceGreaterThan ( Double amount );

    List<OrderDetail> findByProductNameContainingIgnoreCase ( String keyword );
}
