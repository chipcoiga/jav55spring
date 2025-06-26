package vn.com.iviettech.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.iviettech.entity.AccountEntity;

import java.util.List;

public interface AccountRepository
        extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findAllByNameContains(String text);

    @Query("Select ae from AccountEntity ae " +
            "where ae.name like %:text% and ae.salary >= :salary")
    List<AccountEntity> findByNameAndSalary(
            @Param("text") String text,
            @Param("salary") Long salary);

    List<AccountEntity> findAllByNameContainsAndSalaryGreaterThan(String text, Long salary);
    List<AccountEntity> findAllByNameContains(String text, Pageable pageable);
}
