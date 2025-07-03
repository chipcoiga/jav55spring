package bai3.repository;


import bai3.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByCategory_Name(String name);

    @Query("SELECT b FROM BookEntity b WHERE b.pageCount > :pageCount")
    List<BookEntity> findByPageCountGreaterThan(int pageCount);

}


