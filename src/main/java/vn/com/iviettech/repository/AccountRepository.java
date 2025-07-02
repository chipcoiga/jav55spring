package vn.com.iviettech.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.iviettech.domain.OrderStatistic;
import vn.com.iviettech.entity.AccountEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface AccountRepository
        extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findAllByNameContains(String text);

    @Query("Select ae from AccountEntity ae " +
            "where ae.name like %:text% and ae.salary >= :salary")
    List<AccountEntity> findByNameAndSalary(
            @Param("text") String text,
            @Param("salary") Long salary);

//    @Query("Select ae from AccountEntity ae " +
//            "where ae.name like %?1% and ae.salary >= ?2")
//    List<AccountEntity> findByNameAndSalaryx(
//            String text,
//            Long salary);

    List<AccountEntity> findAllByNameContainsAndSalaryGreaterThan(String text, Long salary);
    List<AccountEntity> findAllByNameContains(String text, Pageable pageable);

//    @Query("select new annotaioncofig.model.OrderStatistic(" +
//            "o.orderDate, " +
//            "o.customerName, " +
//            "od.product.category.name, " +
//            "od.productName, " +
//            "sum(od.quantity), " +
//            "sum(od.subtotal), " +
//            "max(od.price)) " +
//            "from OrderEntity o join o.orderDetails od " +
//            "where od.product.category.name = :categoryName " +
//            "and od.productName = :productName " +
//            "and o.orderDate between :fromDate and :toDate " +
//            "group by o.orderDate, o.customerName, od.product.category.name, od.productName")
//    List<OrderStatistic> findStatisticByProductNameAndOrderDateBetweenAndCategoryName(
//            @Param("productName") String productName,
//            @Param("fromDate") LocalDateTime fromDate,
//            @Param("toDate") LocalDateTime toDate,
//            @Param("categoryName") String categoryName
//    );

}
