package vn.com.iviettech.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    private List<BookDetailEntity> bookDetails ;

    private String author;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<BookDetailEntity> getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(List<BookDetailEntity> bookDetails) {
        this.bookDetails = bookDetails;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
