package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import vn.com.iviettech.entity.AccountEntity;
import vn.com.iviettech.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void createAccount(AccountEntity entity) {
        repository.save(entity);
    }


    public List<AccountEntity> findAccountsBySalaryRange() {
        return repository.findAllBySalaryBetween(10000000L, 15000000L);
    }


    public Long countAccountsBySalaryRange() {
        return repository.countBySalaryBetween(10000000L, 15000000L);
    }


    public Optional<AccountEntity> findAccountByNameLike() {
        return repository.findFirstByNameContainingOrNameContaining("K", "D");
    }

    public List<AccountEntity> findAccountsByNameLike() {
        return repository.findAllByNameContainingIgnoreCaseOrNameContainingIgnoreCase("K", "D");
    }



    @PostConstruct
    public void initData() {

//        AccountEntity entity1 = new AccountEntity();
//        entity1.setName("Nguyen Van Anh Kieu");
//        entity1.setSalary(12000000L);
//        createAccount(entity1);
//
//        AccountEntity entity2 = new AccountEntity();
//        entity2.setName("Tran Thi nguyen");
//        entity2.setSalary(14000000L);
//        createAccount(entity2);
//
//        AccountEntity entity3 = new AccountEntity();
//        entity3.setName("Le Van viet");
//        entity3.setSalary(18900000L); //
//        createAccount(entity3);
//
//        AccountEntity entity4 = new AccountEntity();
//        entity4.setName("Hoang Thi Dung");
//        entity4.setSalary(8000000L);
//        createAccount(entity4);


        System.out.println("=== Test tìm accounts có salary 10-15 triệu ===");
        findAccountsBySalaryRange().forEach(entity -> {
            System.out.println("ID: " + entity.getId());
            System.out.println("Name: " + entity.getName());
            System.out.println("Salary: " + entity.getSalary());
            System.out.println("-------");
        });

        System.out.println("=== Đếm accounts có salary 10-15 triệu ===");
        Long count = countAccountsBySalaryRange();
        System.out.println("Số lượng: " + count);

        System.out.println("=== Kết quả tìm kiếm TEN có tên chứa 'K' hoặc 'D' ===");
        List<AccountEntity> matchedAccounts = findAccountsByNameLike();
        if (matchedAccounts.isEmpty()) {
            System.out.println("Không tìm thấy TEN nào phù hợp với từ khóa 'K' OR 'D'.");
        } else {
            matchedAccounts.forEach(entity -> {
                System.out.println("ID      : " + entity.getId());
                System.out.println("  Name  : " + entity.getName());
                System.out.println("  Salary   : " + entity.getSalary());
                System.out.println("-----------");
            });


            repository.findAllByNameContains("4").forEach(entity -> {
                System.out.println(entity.getId());
                System.out.println(entity.getName());
                System.out.println(entity.getSalary());
                System.out.println("=======");
            });
        }
    }
}
