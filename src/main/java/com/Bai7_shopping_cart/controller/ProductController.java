package com.Bai7_shopping_cart.controller;

import com.Bai7_shopping_cart.model.ProductEntity;
import com.Bai7_shopping_cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String showProductList(Model model) {
        List<ProductEntity> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "productList"; // Sẽ nạp file productList.html
    }
}
