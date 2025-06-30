package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
