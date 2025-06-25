package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.iviettech.entity.AccountEntity;

import java.util.List;
import java.util.Optional;

public interface AccountRepository
        extends JpaRepository<AccountEntity, Long> {
    List<AccountEntity> findAllByNameContains(String text);
    List<AccountEntity> findAllBySalaryBetween(Long minSalary, Long maxSalary);

    Long countBySalaryBetween(Long minSalary, Long maxSalary);

    //dem
    Optional<AccountEntity> findFirstByNameContainingOrNameContaining(String text1, String text2);

//tim name
    List<AccountEntity> findByNameStartingWithIgnoreCaseOrNameStartingWithIgnoreCase(String prefix1, String prefix);

    List<AccountEntity> findAllByNameContainingIgnoreCaseOrNameContainingIgnoreCase(String keyword1, String keyword);
}


