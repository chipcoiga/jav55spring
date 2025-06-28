package com.example.demo.repository;

import com.example.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // Yêu cầu 1: tìm trong khoảng lương
    List<Account> findBySalaryBetween(Long minSalary, Long maxSalary);

    // Yêu cầu 2: đếm số lượng tài khoản trong khoảng lương
    Long countBySalaryBetween(Long minSalary, Long maxSalary);

    // Yêu cầu 3: tìm tài khoản có tên LIKE ... hoặc ...
    Account findFirstByNameContainingOrNameContaining(String name1, String name2);
}
