package com.vn.book.entity.repository;

import com.vn.book.entity.entity.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {
}

