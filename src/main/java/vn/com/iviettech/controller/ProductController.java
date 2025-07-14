package vn.com.iviettech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.com.iviettech.service.ProductService;

@Controller
public class ProductController {


    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "productList";
    }
}//.

