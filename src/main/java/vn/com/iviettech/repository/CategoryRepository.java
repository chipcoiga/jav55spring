package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
