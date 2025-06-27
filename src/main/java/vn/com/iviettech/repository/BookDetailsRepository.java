package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.iviettech.entity.BookDetailsEntity;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookDetailsRepository extends JpaRepository<BookDetailsEntity, Integer> {

    // search details theo ISBN
    Optional<BookDetailsEntity> findByIsbn(String isbn);

    // Tìm details theo book ID
    Optional<BookDetailsEntity> findByBookId(Integer bookId);

    // Tìm book theo price
    List<BookDetailsEntity> findByPriceBetween(Integer minPrice, Integer maxPrice);

    // Tìm book có số trang lớn hơn
    List<BookDetailsEntity> findByNumberOfPageGreaterThan(Integer pages);

    // Tìm details với thông tin sách
    @Query("SELECT bd FROM BookDetailsEntity bd LEFT JOIN FETCH bd.book WHERE bd.id = :id")
    Optional<BookDetailsEntity> findByIdWithBook(@Param("id") Integer id);

    // Tìm all detail với thông tin sách
    @Query("SELECT bd FROM BookDetailsEntity bd LEFT JOIN FETCH bd.book")
    List<BookDetailsEntity> findAllWithBook();
}
