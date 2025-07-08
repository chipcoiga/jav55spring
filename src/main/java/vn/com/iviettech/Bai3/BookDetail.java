package vn.com.iviettech.Bai3;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class BookDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String isbn;
    private Integer numbersOfPage;
    private double price;
    private LocalDate publishedDate;

    @OneToOne(mappedBy = "bookDetail")
    private Book book;
    public BookDetail (){}

    public BookDetail(Long id, String isbn, Integer numbersOfPage, double price, LocalDate publishedDate, Book book) {
        this.id = id;
        this.isbn = isbn;
        this.numbersOfPage = numbersOfPage;
        this.price = price;
        this.publishedDate = publishedDate;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNumbersOfPage() {
        return numbersOfPage;
    }

    public void setNumbersOfPage(Integer numbersOfPage) {
        this.numbersOfPage = numbersOfPage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
