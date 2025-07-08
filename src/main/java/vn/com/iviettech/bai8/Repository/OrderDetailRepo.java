package vn.com.iviettech.bai8.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.iviettech.bai8.Entity.OrderDetail;
@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {
}
