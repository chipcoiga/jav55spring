package vn.com.iviettech.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookdetails")
public class BookDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "numberOfPage")
    private Integer numberOfPage;

    @Column(name = "price")
    private Integer price;

    @Column(name = "publishDate")
    @Temporal(TemporalType.DATE)
    private Date publishDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private BookEntity book;

    public BookDetailsEntity() {}

    public BookDetailsEntity(String isbn, Integer numberOfPage, Integer price, Date publishDate) {
        this.isbn = isbn;
        this.numberOfPage = numberOfPage;
        this.price = price;
        this.publishDate = publishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(Integer numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookDetailsEntity{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", numberOfPage=" + numberOfPage +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", bookId=" + (book != null ? book.getId() : null) +
                '}';
    }
}