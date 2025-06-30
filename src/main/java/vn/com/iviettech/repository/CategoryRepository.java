package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.CategoryEntity;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    List<CategoryEntity> findByNameContainingIgnoreCase(String name);

}
