package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    // Tìm sách theo tên gần đúng
    List<Book> findByNameContaining(String keyword);

    // Tìm sách theo tên thể loại
    List<Book> findByCategory_Name(String categoryName);
}
