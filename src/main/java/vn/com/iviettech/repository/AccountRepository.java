package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.iviettech.entity.AccountEntity;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findAllByNameContainsAndSalaryGreaterThan(String name, Long salary);

    List<AccountEntity> findBySalaryBetween(Long min, Long max);

}
