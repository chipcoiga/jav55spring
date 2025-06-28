package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Yêu cầu 1
    @GetMapping("/salary")
    public List<Account> getAccountsBySalaryRange(
            @RequestParam Long min,
            @RequestParam Long max) {
        return accountService.findAccountsBySalaryRange(min, max);
    }

    // Yêu cầu 2
    @GetMapping("/salary/count")
    public Long countAccountsBySalaryRange(
            @RequestParam Long min,
            @RequestParam Long max) {
        return accountService.countAccountsBySalaryRange(min, max);
    }

    // Yêu cầu 3
    @GetMapping("/search")
    public Account findByNameLike(
            @RequestParam String name1,
            @RequestParam String name2) {
        return accountService.findAccountByNameLike(name1, name2);
    }
}
