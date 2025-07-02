package vn.com.iviettech.Bai3;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookDetailRepository bookDetailRepository;
    private final CategoryRepository categoryRepository;

    public BookService(BookRepository bookRepository, BookDetailRepository bookDetailRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.bookDetailRepository = bookDetailRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void init() {
//        query

        List<Book> bookList = bookRepository.findByCategory_Name("Novel");

        System.out.println("lists 'Novel':");
        for (Book b : bookList) {
            System.out.println("------");
            System.out.println("ID: " + b.getId());
            System.out.println("name: " + b.getName());
            System.out.println("author: " + b.getAuthor());

            // BookDetail
            BookDetail detail = b.getBookDetail();
            if (detail != null) {
                System.out.println("ISBN: " + detail.getIsbn());
                System.out.println("pages: " + detail.getNumbersOfPage());
                System.out.println("price: " + detail.getPrice());
                System.out.println("published date: " + detail.getPublishedDate());
            }

            // Category
            Category c = b.getCategory();
            if (c != null) {
                System.out.println("category: " + c.getName());
                System.out.println("description " + c.getDescription());
            }


//        query

            Category category = new Category();
            category.setName("Novel");
            category.setDescription("love story...");

            List<Book> books = new ArrayList<>();
            Book book1 = new Book();
            book1.setName("To the moon");
            book1.setAuthor("Bill");
            books.add(book1);

            BookDetail bookDetail = new BookDetail();
            bookDetail.setIsbn("123");
            bookDetail.setPrice(20000);
            bookDetail.setNumbersOfPage(200);
            bookDetail.setPublishedDate(LocalDate.of(2025, 06, 29));
            book1.setBookDetail(bookDetail);
            bookDetail.setBook(book1);

            Book book2 = new Book();
            book2.setName("flat earth");
            book2.setAuthor("Kacie");
            books.add(book2);

            BookDetail bookDetail1 = new BookDetail();
            bookDetail1.setIsbn("456");
            bookDetail1.setPrice(30000);
            bookDetail1.setNumbersOfPage(200);
            bookDetail1.setPublishedDate(LocalDate.of(2023, 06, 29));
            book2.setBookDetail(bookDetail1);
            bookDetail1.setBook(book2);

            category.setBooks(books);

            for (Book book : books) {
                book.setCategory(category);
            }


            categoryRepository.save(category);


            System.out.println("print: ");
//        for(Book book: books){
//            System.out.println(book.getId());
//            System.out.println(book.getAuthor());
//            System.out.println(book.getName());
//            System.out.println(book.getCategory());
//            System.out.println(book.getBookDetail().getBook());
//            System.out.println(book.getBookDetail().getIsbn());
//            System.out.println(book.getBookDetail().getId());
//            System.out.println(book.getBookDetail().getNumbersOfPage());
//            System.out.println(book.getBookDetail().getPublishedDate());
//            System.out.println(book.getCategory().getBooks());
//            System.out.println(book.getCategory().getDescription());
//            System.out.println(book.getCategory().getName());
//            System.out.println(book.getCategory().getId());
//
//
//        }

            for (Book book : books) {
                System.out.println("Book ID: " + book.getId());
                System.out.println("Name: " + book.getName());
                System.out.println("Author: " + book.getAuthor());

                BookDetail bd = book.getBookDetail();
                System.out.println(" - ISBN: " + bd.getIsbn());
                System.out.println(" - Pages: " + bd.getNumbersOfPage());
                System.out.println(" - Price: " + bd.getPrice());
                System.out.println(" - Published: " + bd.getPublishedDate());

                Category cat = book.getCategory();
                System.out.println(" - Category: " + cat.getName() + " - " + cat.getDescription());
                System.out.println("---------------------------------");
            }


        }
    }
}
