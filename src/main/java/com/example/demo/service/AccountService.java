package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAccountsBySalaryRange(Long min, Long max) {
        return accountRepository.findBySalaryBetween(min, max);
    }

    public Long countAccountsBySalaryRange(Long min, Long max) {
        return accountRepository.countBySalaryBetween(min, max);
    }

    public Account findAccountByNameLike(String name1, String name2) {
        return accountRepository.findFirstByNameContainingOrNameContaining(name1, name2);
    }
}
