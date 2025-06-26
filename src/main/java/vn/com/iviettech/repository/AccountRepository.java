package vn.com.iviettech.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.AccountEntity;

import java.util.List;

public interface AccountRepository
        extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findAllByNameContains(String text);
    List<AccountEntity> findAllByNameContainsAndSalaryGreaterThan(String text, Long salary);
    List<AccountEntity> findAllByNameContains(String text, Pageable pageable);
}
