package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.iviettech.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{
}

