package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.AccountEntity;
import vn.com.iviettech.repository.AccountRepository;

@Service
public class AccountService {

    private AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void createAccount(AccountEntity entity) {
        repository.save(entity);
    }

    @PostConstruct
    public void initData() {
//        repository.findAllByNameContainsAndSalaryGreaterThan("", 10000000L)
//                .forEach(entity -> {
//            System.out.println(entity.getId());
//            System.out.println(entity.getName());
//            System.out.println(entity.getSalary());
//            System.out.println("======");
//        });

        repository.findAllBySalaryBetween(10000000l, 15000000l).forEach(entity->{
            System.out.println(entity.getId());
            System.out.println(entity.getName());
            System.out.println(entity.getSalary());
        });

        repository.findAllByNameContainingOrNameContaining("3","1").forEach(accountEntity ->
        {
            System.out.println(accountEntity.getSalary());
            System.out.println(accountEntity.getName());
            System.out.println(accountEntity.getId());
        });
//
        long count = repository.countBySalaryBetween(10000000l,15000000l);
        System.out.println(count);

//        repository.findAllByNameContains("4").forEach(entity -> {
//            System.out.println(entity.getId());
//            System.out.println(entity.getName());
//            System.out.println(entity.getSalary());
//            System.out.println("======");
//        });

//        repository.findAll().forEach(entity -> {
//            System.out.println(entity.getId());
//            System.out.println(entity.getName());
//            System.out.println(entity.getSalary());
//            System.out.println("======");
//        });

        AccountEntity entity1 = new AccountEntity();
        entity1.setName("Account 1");
        entity1.setSalary(10000000L);
        createAccount(entity1);

        AccountEntity entity2 = new AccountEntity();
        entity2.setName("Account 2");
        entity2.setSalary(15000000L);
        createAccount(entity2);

        AccountEntity entity3 = new AccountEntity();
        entity3.setName("Account 3");
        entity3.setSalary(5000000L);
        createAccount(entity3);

        AccountEntity entity4 = new AccountEntity();
        entity4.setName("Account 4");
        entity4.setSalary(50000000L);
        createAccount(entity4);
    }
}
