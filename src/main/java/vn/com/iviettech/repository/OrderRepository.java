package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.iviettech.entity.OrderEntity;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    @Query("SELECT o FROM OrderEntity o WHERE o.orderDate BETWEEN :start AND :end")
    List<OrderEntity> findOrdersInDateRange(@Param("start") LocalDate start, @Param("end") LocalDate end);

    @Query("SELECT o FROM OrderEntity o JOIN o.orderDetails d GROUP BY o.id HAVING SUM(d.quantity * d.price) > 1000")
    List<OrderEntity> findOrdersWithTotalAmountGreaterThan1000();

    @Query("SELECT DISTINCT o FROM OrderEntity o JOIN o.orderDetails d WHERE LOWER(d.productName) LIKE %:keyword%")
    List<OrderEntity> findOrdersWithProductName(@Param("keyword") String keyword);
}
