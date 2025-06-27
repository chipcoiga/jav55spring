package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import vn.com.iviettech.entity.BookDetailsEntity;
import vn.com.iviettech.entity.BookEntity;
import vn.com.iviettech.entity.CategoryEntity;
import vn.com.iviettech.repository.BookDetailsRepository;
import vn.com.iviettech.repository.BookRepository;
import vn.com.iviettech.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookDetailsRepository bookDetailsRepository;
    private final CategoryRepository categoryRepository;

    public BookService(BookDetailsRepository bookDetailsRepository,
                       BookRepository bookRepository,
                       CategoryRepository categoryRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {
        // dùng try cath xem quá trình Tạo Dâta có lỗi không

        try {
            // 1. Tạo Category
            CategoryEntity category = new CategoryEntity();
            category.setName("Programming");
            category.setDescription(" Programming Technology Trường Coder quá khổ");
            category = categoryRepository.save(category);
            System.out.println("✅ Category đã được tạo - ID: " + category.getId());

            // 2. Tạo Book
            BookEntity book = new BookEntity();
            book.setName("Java Fundamentals");
            book.setAuthor("Trường Đỉnh Cao");
            book.setCategory(category);
            book = bookRepository.save(book);
            System.out.println("✅ Book đã được tạo - ID: " + book.getId());


            BookDetailsEntity details = new BookDetailsEntity();
            details.setBook(book);
            details.setIsbn("978-1234567890");
            details.setNumberOfPage(300);
            details.setPrice(250000);
            details.setPublishDate(java.sql.Date.valueOf("2024-06-01"));
            details = bookDetailsRepository.save(details);
            System.out.println("BookDetails được trường tạo - ID: " + details.getId());

            // 4. Cập nhật quan hệ bidirectional
            book.setBookDetails(details);
            bookRepository.save(book);
            System.out.println("Quan hệ bidirectional đã được thiết lập");

            // 5. Tạo thêm dữ liệu mẫu
            createSampleData();

            // 6. Kiểm tra kết quả
            printOrderInfo();

        } catch (Exception e) {
            System.err.println("❌ Lỗi trong quá trình khởi tạo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Tạo thêm dữ liệu mẫu copy thầy  Al nhành :))
     */
    @Transactional
    public void createSampleData() {
        System.out.println(" Tạo dữ liệu mẫu...");

        // Category 2
        CategoryEntity webCategory = new CategoryEntity("Web Development", "Books about Web Technologies");
        webCategory = categoryRepository.save(webCategory);

        // Book 2
        BookEntity reactBook = new BookEntity("React JS Complete Guide", "Nguyễn Văn A");
        reactBook.setCategory(webCategory);
        reactBook = bookRepository.save(reactBook);

        // BookDetails 2
        BookDetailsEntity reactDetails = new BookDetailsEntity("978-9876543210", 450, 300000,
                java.sql.Date.valueOf("2024-07-15"));
        reactDetails.setBook(reactBook);
        bookDetailsRepository.save(reactDetails);

        reactBook.setBookDetails(reactDetails);
        bookRepository.save(reactBook);

        System.out.println("✅ Dữ liệu mẫu đã được tạo");
    }


    public void printOrderInfo() {
        System.out.println("\n====================== THÔNG TIN ĐƠN HÀNG ======================");


            // Thống kê tổng quan
            long categoryCount = categoryRepository.count();
            long bookCount = bookRepository.count();
            long detailsCount = bookDetailsRepository.count();

            System.out.println("THỐNG KÊ TỔNG QUAN:");
            System.out.println("Tổng danh mục: " + categoryCount);
            System.out.println("Tổng sách: " + bookCount);
            System.out.println("Tổng chi tiết sách: " + detailsCount);


            List<CategoryEntity> categories = categoryRepository.findAll();
            System.out.println("DANH MỤC SÁCH:");
            for (CategoryEntity cat : categories) {
                System.out.println("   • ID: " + cat.getId() + " | " + cat.getName() + " - " + cat.getDescription());
            }

            //
            List<BookEntity> books = bookRepository.findAllWithCategory();
            System.out.println(" DANH SÁCH SÁCH:");
            for (BookEntity book : books) {
                System.out.println("   • ID: " + book.getId() + " | " + book.getName());
                System.out.println("     Tác giả: " + book.getAuthor());
                System.out.println("     Danh mục: " + (book.getCategory() != null ? book.getCategory().getName() : "N/A"));
                System.out.println("     Có chi tiết: " + (book.getBookDetails() != null ? "✅" : "❌"));
                System.out.println();
            }


            List<BookDetailsEntity> details = bookDetailsRepository.findAllWithBook();
            System.out.println(" CHI TIẾT SÁCH:");
            if (details.isEmpty()) {
                System.out.println("    KHÔNG CÓ CHI TIẾT SÁCH NÀO!");
            } else {
                for (BookDetailsEntity detail : details) {
                    System.out.println("   • ID: " + detail.getId() + " | ISBN: " + detail.getIsbn());
                    System.out.println("     Tên sách: " + (detail.getBook() != null ? detail.getBook().getName() : "N/A"));
                    System.out.println("     Số trang: " + detail.getNumberOfPage() + " | Giá: " + String.format("%,d VNĐ", detail.getPrice()));
                    System.out.println("     Ngày XB: " + detail.getPublishDate());
                    System.out.println();
                }
            }

            // Kiểm tra quan hệ
            System.out.println(" KIỂM TRA QUAN HỆ:");
            for (BookEntity book : books) {
                BookDetailsEntity bookDetail = book.getBookDetails();
                if (bookDetail != null) {
                    boolean bidirectionalOK = bookDetail.getBook() != null &&
                            bookDetail.getBook().getId().equals(book.getId());
                    System.out.println("   • Sách '" + book.getName() + "' ↔ Chi tiết: " +
                            (bidirectionalOK ? "✅ OK" : "Lỗi"));
                } else {
                    System.out.println("   • Sách '" + book.getName() + "': Không có chi tiết");
                }
            }


        System.out.println("===============================================================\n");
    }



    //Search ID
    public Optional<BookEntity> findBookWithFullInfo(Integer id) {
        return bookRepository.findByIdWithFullInfo(id);
    }

    //search danh muc category
    public List<BookEntity> findBooksByCategory(Integer categoryId) {
        return bookRepository.findByCategoryId(categoryId);
    }

    //search trong  <>
    public List<BookDetailsEntity> findBooksByPriceRange(Integer minPrice, Integer maxPrice) {
        return bookDetailsRepository.findByPriceBetween(minPrice, maxPrice);
    }

    /**
     * Tạo sách mới với chi tiết
     */
    @Transactional
    public BookEntity createBookWithDetails(String bookName, String author, Integer categoryId,
                                            String isbn, Integer pages, Integer price, java.sql.Date publishDate) {
        try {
            // Tìm category
            CategoryEntity category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Category not found: " + categoryId));

            // Tạo book
            BookEntity book = new BookEntity(bookName, author);
            book.setCategory(category);
            book = bookRepository.save(book);

            // Tạo details
            BookDetailsEntity details = new BookDetailsEntity(isbn, pages, price, publishDate);
            details.setBook(book);
            details = bookDetailsRepository.save(details);

            // Cập nhật quan hệ
            book.setBookDetails(details);
            book = bookRepository.save(book);

            System.out.println("Đã tạo sách mới: " + bookName);
            return book;

        } catch (Exception e) {
            System.err.println("Lỗi tạo sách: " + e.getMessage());
            throw e;
        }
    }
}