package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.iviettech.entity.BookEntity;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    // tim name
    List<BookEntity> findByNameContainingIgnoreCase(String name);

    // search author
    List<BookEntity> findByAuthorContainingIgnoreCase(String author);

    // Tìm sách theo category
    List<BookEntity> findByCategoryId(Integer categoryId);

    // search all (bao gồm category và details) viet theo kieu qery
    @Query("SELECT b FROM BookEntity b LEFT JOIN FETCH b.category LEFT JOIN FETCH b.bookDetails WHERE b.id = :id")
    Optional<BookEntity> findByIdWithFullInfo(@Param("id") Integer id);

    // all search category
    @Query("SELECT b FROM BookEntity b LEFT JOIN FETCH b.category")
    List<BookEntity> findAllWithCategory();

    // Tìm sách có bookDetails
    @Query("SELECT b FROM BookEntity b WHERE b.bookDetails IS NOT NULL")
    List<BookEntity> findBooksWithDetails();
}
