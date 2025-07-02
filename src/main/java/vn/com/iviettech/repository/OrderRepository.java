package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.iviettech.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderRepository
        extends JpaRepository<OrderEntity, Integer> {
    @Query("SELECT o FROM OrderEntity o LEFT JOIN FETCH o.orderDetails WHERE o.id = :id")
    Optional<OrderEntity> findOrderWithDetails(@Param("id") Integer id);

    @Query("SELECT o FROM OrderEntity o WHERE FUNCTION('MONTH', o.orderDate) = :month AND FUNCTION('YEAR', o.orderDate) = :year")
    List<OrderEntity> findAllByMonthAndYear(@Param("month") int month, @Param("year") int year);

}//.
