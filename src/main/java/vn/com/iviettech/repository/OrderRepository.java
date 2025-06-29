package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.com.iviettech.entity.OrderEntity;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    // Orders in current month
    @Query("SELECT o FROM OrderEntity o WHERE MONTH(o.orderDate) = MONTH(CURRENT_DATE) AND YEAR(o.orderDate) = YEAR(CURRENT_DATE)")
    List<OrderEntity> findOrdersInCurrentMonth();

    // Orders with total amount > 1000
    @Query("SELECT o FROM OrderEntity o JOIN o.orderDetails d GROUP BY o HAVING SUM(d.quantity * d.price) > :amount")
    List<OrderEntity> findOrdersWithTotalAmountGreaterThan(double amount);

    // Orders containing Java books
    @Query("SELECT DISTINCT o FROM OrderEntity o JOIN o.orderDetails d WHERE LOWER(d.productName) LIKE %:keyword%")
    List<OrderEntity> findOrdersByProductNameContainingIgnoreCase(String keyword);
}
