package vn.com.iviettech.Bai3;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BController {
    private final BookService service;

    public BController(BookService service) {
        this.service = service;
    }


    @GetMapping
    public String showBooks(Model model) {
        model.addAttribute("books", service.getAllBook());
        return "book_list";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String name, @RequestParam String author,
                          @RequestParam String isbn, @RequestParam int page,
                          @RequestParam String categoryName, @RequestParam String categoryDesc
                          ) {

        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        BookDetail bookDetail = new BookDetail();
        bookDetail.setNumbersOfPage(page);
        bookDetail.setIsbn(isbn);
        book.setBookDetail(bookDetail);
        Category category = new Category();
        category.setName(categoryName);
        category.setDescription(categoryDesc);
        book.setCategory(category);
        service.save(book);
        return "redirect:/books";
    }

    @PostMapping("/edit")
    public String editBook(@RequestParam Long id,
                           @RequestParam String name,
                           @RequestParam String author,
                           @RequestParam String isbn,
                           @RequestParam int page,
                           @RequestParam String categoryName,
                           @RequestParam String categoryDesc) {
        Book updatedBook = new Book();
        updatedBook.setName(name);
        updatedBook.setAuthor(author);

        BookDetail detail = new BookDetail();
        detail.setIsbn(isbn);
        detail.setNumbersOfPage(page);
        updatedBook.setBookDetail(detail);

        Category category = new Category();
        category.setName(categoryName);
        category.setDescription(categoryDesc);
        updatedBook.setCategory(category);

        service.updateBook(id, updatedBook);
        return "redirect:/books";

    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam Long id) {
        service.deleteBookById(id);
        return "redirect:/books";
    }
}