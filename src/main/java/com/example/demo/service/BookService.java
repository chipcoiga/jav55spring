package com.example.demo.service;

import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchByName(String keyword) {
        return bookRepository.findByNameContaining(keyword);
    }

    public List<Book> searchByCategory(String categoryName) {
        return bookRepository.findByCategory_Name(categoryName);
    }
}
