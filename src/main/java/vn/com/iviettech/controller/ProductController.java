package vn.com.iviettech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.com.iviettech.repository.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "productList";
    }
}
