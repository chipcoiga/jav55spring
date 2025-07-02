package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.iviettech.domain.OrderTotalDTO;
import vn.com.iviettech.entity.OrderDetailEntity;
import vn.com.iviettech.entity.OrderEntity;

import java.util.List;

public interface OrderDetailRepository
        extends JpaRepository<OrderDetailEntity, Integer> {

    @Query("SELECT new vn.com.iviettech.domain.OrderTotalDTO(o.id, o.customerName, SUM(d.quantity * d.unitPrice)) " +
            "FROM OrderDetailEntity d " +
            "JOIN d.order o " +
            "GROUP BY o.id, o.customerName " +
            "HAVING SUM(d.quantity * d.unitPrice) > 1000")
    List<OrderTotalDTO> findOrdersWithTotalGreaterThan1000();

    @Query("SELECT DISTINCT d.order FROM OrderDetailEntity d WHERE LOWER(d.productName) LIKE %:keyword%")
    List<OrderEntity> findOrdersByProductNameContaining(@Param("keyword") String keyword);

}
