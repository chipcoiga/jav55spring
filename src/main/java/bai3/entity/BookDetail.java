package bai3.entity;

import jakarta.persistence.*;

@Entity
public class BookDetail {
    @Id
    private Long id;

    private String summary;
    private String isbn;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private BookEntity book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
}


