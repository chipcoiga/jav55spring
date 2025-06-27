package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.com.iviettech.entity.CategoryEntity;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    // searh name
    Optional<CategoryEntity> findByName(String name);

    // search category có chứa từ khóa trong tên
    List<CategoryEntity> findByNameContainingIgnoreCase(String keyword);

    // count sách trong category--danh muc
    @Query("SELECT c FROM CategoryEntity c LEFT JOIN FETCH c.books WHERE c.id = :id")
    Optional<CategoryEntity> findByIdWithBooks(Integer id);
}
