package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.iviettech.entity.BookDetailEntity;
import vn.com.iviettech.entity.BookEntity;
import vn.com.iviettech.repository.BookDetailRepository;
import vn.com.iviettech.repository.BookRepository;

import java.time.LocalDate;
import java.util.Date;

@Service
public class BookService {
    private BookRepository bookRepository;
    private BookDetailRepository bookDetailRepository;

    public BookService(BookRepository bookRepository, BookDetailRepository bookDetailRepository) {
        this.bookRepository = bookRepository;
        this.bookDetailRepository = bookDetailRepository;
    }
    @Transactional
    @PostConstruct

    public void initData(){
//        BookEntity bookEntity1 = new BookEntity();
//        bookEntity1.setAuthor("Thầy lộc1");
//        bookEntity1.setName("Java ");
//        bookRepository.save(bookEntity1);
//
//        BookEntity bookEntity2 = new BookEntity();
//        bookEntity2.setAuthor("Thầy lộc2");
//        bookEntity2.setName("Java Spring boot");
//        bookRepository.save(bookEntity2);
//
//        BookEntity bookEntity3 = new BookEntity();
//        bookEntity3.setAuthor("Thầy Tân");
//        bookEntity3.setName("MySql");
//        bookRepository.save(bookEntity3);
//
//        BookDetailEntity bookDetailEntity1 = new BookDetailEntity();
//        bookDetailEntity1.setIsbn("1234563421");
//        bookDetailEntity1.setNumberOfPage(123234346);
//        bookDetailEntity1.setPrice(1000000L);
//        bookDetailEntity1.setPublish(LocalDate.of(2025,06,07));
//        bookDetailRepository.save(bookDetailEntity1);
//
//        BookDetailEntity bookDetailEntity2 = new BookDetailEntity();
//        bookDetailEntity2.setIsbn("1465563421");
//        bookDetailEntity2.setNumberOfPage(1354134346);
//        bookDetailEntity2.setPrice(1600000L);
//        bookDetailEntity2.setPublish(LocalDate.of(2022,04,05));
//        bookDetailRepository.save(bookDetailEntity2);
//
//        BookDetailEntity bookDetailEntity3 = new BookDetailEntity();
//        bookDetailEntity1.setIsbn("1234563421");
//        bookDetailEntity1.setNumberOfPage(123234346);
//        bookDetailEntity1.setPrice(1900000L);
//        bookDetailEntity1.setPublish(LocalDate.of(2023,06,07));
//        bookDetailRepository.save(bookDetailEntity3);

    }
}
