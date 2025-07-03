package com.vn.book.entity.Service;

import com.vn.book.entity.entity.BookEntity;
import com.vn.book.entity.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getBooksByCategory(String categoryName) {
        return bookRepository.findByCategory_Name(categoryName);
    }

    public BookEntity save(BookEntity book) {
        return bookRepository.save(book);
    }
}

