package vn.com.iviettech.bai7;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);
    List<Book> findByNameContaining(String keyword);
    List<Book> findByCategoryName(String name);
    List<Book> findByCategory_Name(String name);

}
