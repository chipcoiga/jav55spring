package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.AccountEntity;

import java.util.List;

public interface AccountRepository
        extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findAllByNameContains(String text);
    List<AccountEntity> findAllByNameContainsAndSalaryGreaterThan(String text, Long salary);
    List<AccountEntity> findAllBySalaryBetween(Long minSalary, Long maxSalary);
    List<AccountEntity> findAllByNameContainingOrNameContaining(String a, String b);
    long countBySalaryBetween(Long minSalary, Long maxSalary);
}
