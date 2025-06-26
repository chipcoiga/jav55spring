package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.AccountEntity;
import vn.com.iviettech.repository.AccountRepository;

import java.util.List;

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
        //Pagable with sort
//        Sort sort = Sort.by(Sort.Direction.DESC, "salary", "name");
//        PageRequest pageable = PageRequest.of(0, 4, sort);
//
//        repository.findAllByNameContains("", pageable)
//                .forEach(entity -> {
//                    System.out.println(entity.getId());
//                    System.out.println(entity.getName());
//                    System.out.println(entity.getSalary());
//                    System.out.println("======");
//                });


        //Pagaable
//        PageRequest pageable = PageRequest.of(2, 2);
//        repository.findAllByNameContains("", pageable)
//                .forEach(entity -> {
//                    System.out.println(entity.getId());
//                    System.out.println(entity.getName());
//                    System.out.println(entity.getSalary());
//                    System.out.println("======");
//                });

        repository.findByNameAndSalary("", 10000000L)
                .forEach(entity -> {
            System.out.println(entity.getId());
            System.out.println(entity.getName());
            System.out.println(entity.getSalary());
            System.out.println("======");
        });

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

//        AccountEntity entity1 = new AccountEntity();
//        entity1.setName("Account 1");
//        entity1.setSalary(10000000L);
//        createAccount(entity1);
//
//        AccountEntity entity2 = new AccountEntity();
//        entity2.setName("Account 2");
//        entity2.setSalary(15000000L);
//        createAccount(entity2);
//
//        AccountEntity entity3 = new AccountEntity();
//        entity3.setName("Account 3");
//        entity3.setSalary(5000000L);
//        createAccount(entity3);
//
//        AccountEntity entity5 = new AccountEntity();
//        entity5.setName("fsdfs@gmail.com");
//        entity5.setSalary(3000000000L);
//        createAccount(entity5);
    }
}
