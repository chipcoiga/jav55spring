package vn.com.iviettech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.iviettech.entity.OrderEntity;
import vn.com.iviettech.service.AccountService;
import vn.com.iviettech.service.OrderService;

@RequestMapping("docs")
@Controller
public class HomeController {

    //https://www.google.com/search?q=khoan+hồng&name=loc&age=10

    //@PatchMapping
    //@PutMapping
    //@DeleteMapping
    //@PostMapping
    //URI path
    //http://localhost:8080/docs/categories/1000/products?q=1&name=1&age=1
    @GetMapping("categories/{categoryId}/products")//http://localhost:8080/docs/categories/3/products
    public String hello(Model model,
                        @PathVariable("categoryId") long categoryId,
                        @RequestParam("q") String q,
                        @RequestParam("name") String name,
                        @RequestParam(value = "age", defaultValue = "10") String age
) {
        System.out.println("q: " + q);
        System.out.println("name: " + name);
        System.out.println("Tuoi: " + age);

        //https://www.thymeleaf.org/doc/articles/springsecurity.html
        model.addAttribute("username", q);
        model.addAttribute("username1", name);
        model.addAttribute("username2", age);
        model.addAttribute("showtenkhac", "fsfdf");
        model.addAttribute("category", categoryId);

        return "locle"; //locle.html
    }

    @GetMapping("emiri-suzuhara")//http://localhost:8080/docs/articles
    public String doSomething(Model model) {
        //https://www.thymeleaf.org/doc/articles/springsecurity.html
        model.addAttribute("username", "Loc lh");

        return "x"; //locle.html
    }
}
