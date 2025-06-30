package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.iviettech.entity.CategoryEntity;
import vn.com.iviettech.repository.CategoryRepository;

import java.util.List;
import java.util.Scanner;

@Service

public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Transactional
    @PostConstruct
    public void initData(){

//        CategoryEntity category1 = new CategoryEntity();
//        category1.setDescription("Sản phẩm 1 mang tính tham khảo");
//        category1.setName("Html,css");
//        categoryRepository.save(category1);
//
//        CategoryEntity category2 = new CategoryEntity();
//        category2.setDescription("Sản phẩm 2 mang tính tham khảo");
//        category2.setName("Mysql");
//        categoryRepository.save(category2);
//
//        CategoryEntity category3 = new CategoryEntity();
//        category3.setDescription("Sản phẩm 3 mang tính tham khảo ");
//        category3.setName("Java,Springboot");
//        categoryRepository.save(category3);
        System.out.println("Nhập tên bạn muốn tìm kiếm:");
        searchName("java").forEach(categoryEntity ->
                System.out.println(categoryEntity.getId() + "_" + categoryEntity.getName()));
    }
    public List<CategoryEntity> searchName(String keyword){
        return categoryRepository.findByNameContainingIgnoreCase(keyword);
    }

}
