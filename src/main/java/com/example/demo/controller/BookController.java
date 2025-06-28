package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    public List<Book> searchByName(@RequestParam String keyword) {
        return bookService.searchByName(keyword);
    }

    @GetMapping("/category")
    public List<Book> searchByCategory(@RequestParam String categoryName) {
        return bookService.searchByCategory(categoryName);
    }
}
