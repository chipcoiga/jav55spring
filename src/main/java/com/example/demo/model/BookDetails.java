package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;
import com.example.demo.model.Book;
@Entity
public class BookDetails {
    @Id
    private Integer id;

    private String isbn;
    private Integer numberOfPage;
    private Integer price;
    private Date publishDate;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Book book;

    // Getters, setters
}
