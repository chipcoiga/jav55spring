package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.AccountEntity;
import vn.com.iviettech.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void createAccount(AccountEntity entity) {
        repository.save(entity);
    }

    @PostConstruct
    public void initData() {
        // Tạo dữ liệu mẫu
        AccountEntity a1 = new AccountEntity();
        a1.setName("Account 1");
        a1.setSalary(10_000_000L);
        createAccount(a1);

        AccountEntity a2 = new AccountEntity();
        a2.setName("Account 2");
        a2.setSalary(15_000_000L);
        createAccount(a2);

        AccountEntity a3 = new AccountEntity();
        a3.setName("Account 3");
        a3.setSalary(5_000_000L);
        createAccount(a3);

        AccountEntity a4 = new AccountEntity();
        a4.setName("Account 4");
        a4.setSalary(50_000_000L);
        createAccount(a4);


        System.out.println("AcountEntity:  Salary>=10000000 <= 15000000 ");
        repository.findAllBySalaryBetween(10000000L, 15000000L).forEach(account -> {
            System.out.println(account.getId());
            System.out.println(account.getName());
            System.out.println(account.getSalary());
            System.out.println("--------");
        });


        long count = repository.countBySalaryBetween(1000000L, 15000000L);
        System.out.println("Số lượng account từ 10tr đến 15tr: " + count);


        System.out.println("=== Tìm account name like 'Acc' OR '4' ===");
        AccountEntity result = repository.findFirstByNameContainingOrNameContaining("Acc", "4");
        if (result != null) {
            System.out.println(result.getId());
            System.out.println(result.getName());
            System.out.println(result.getSalary());
        }
    }
}
