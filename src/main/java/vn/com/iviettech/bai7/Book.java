package vn.com.iviettech.bai7;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String name;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
    public Book(){}

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookDetail_id")
    private BookDetail bookDetail;

    public Book(Long id, String author, Category category, String name) {
        this.id = id;
        this.author = author;
        this.category = category;
        this.name = name;
    }

    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
