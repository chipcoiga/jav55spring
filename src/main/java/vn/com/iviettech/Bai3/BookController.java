//package vn.com.iviettech.Bai3;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/books")
//public class BookController {
//    private final BookService service;
//
//    public BookController(BookService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/bookList")
//    public String getAllBook(Model model){
//        List<Book> books = service.getAllBook();
//       model.addAttribute("books", books);
//       return "bookList";
//    }
//
//    @GetMapping("/book/{id}")
//    public String getBookById(@PathVariable("id") Long id, Model model){
//        Book book = service.findBookById(id);
//        model.addAttribute("book", book);
//        return "bookDetail";
//    }
//
//    @PostMapping("/post")
//    public String createBookWithBookDetail(@RequestBody Book book, Model model){
//        Book newBook = service.createBookWithDetail(book,book.getBookDetail());
//        model.addAttribute("book", newBook);
//        return "bookDetail";
//    }
//
//    @PutMapping("/put/{id}")
//    public String updateBook(Model model, @PathVariable("id") Long id, @RequestBody Book updated){
//        Book existing = service.updateBook(id, updated);
//        model.addAttribute("book", existing);
//        return "bookDetail";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteBookById(Model model, @RequestParam("id") Long id){
//        service.deleteBookById(id);
//        model.addAttribute("message", "deleted" );
//        return "book";
//    }
//}
