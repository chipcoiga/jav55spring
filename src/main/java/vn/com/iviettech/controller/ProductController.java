package vn.com.iviettech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.iviettech.entity.ProductEntity;
import vn.com.iviettech.repository.CategoryRepository;
import vn.com.iviettech.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryRepository categoryRepository;

    public ProductController(ProductService productService, CategoryRepository categoryRepository) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String listProducts(Model model) {
        List<ProductEntity> products = productService.getAll();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new ProductEntity());
        model.addAttribute("categories", categoryRepository.findAll());
        return "product-form";
    }

    @PostMapping("/add")
    public String saveProduct(@ModelAttribute ProductEntity product) {
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model) {
        ProductEntity product = productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryRepository.findAll());
        return "product-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productService.delete(id);
        return "redirect:/products";
    }
}