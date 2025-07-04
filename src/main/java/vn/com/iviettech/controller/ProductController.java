package vn.com.iviettech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.iviettech.entity.Product;
import vn.com.iviettech.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // Trang chủ - Root URL
    @GetMapping("/")
    public String home(Model model) {
        try {
            List<Product> products = productService.getAllProducts();
            model.addAttribute("products", products);
            System.out.println("Trang chủ - Số sản phẩm: " + (products != null ? products.size() : 0));
            return "listproducts";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi tải dữ liệu: " + e.getMessage());
            return "error";
        }
    }

    // Hiển thị trang sản phẩm
    @GetMapping("/products")
    public String showProductPage(Model model) {
        try {
            List<Product> products = productService.getAllProducts();
            model.addAttribute("products", products);
            System.out.println("Trang sản phẩm - Số sản phẩm: " + (products != null ? products.size() : 0));
            return "listproducts";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi tải dữ liệu: " + e.getMessage());
            return "error";
        }
    }

    // Tìm kiếm sản phẩm
    @GetMapping("/products/search")
    public String searchProducts(@RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "minPrice", required = false) Double minPrice,
                                 @RequestParam(value = "maxPrice", required = false) Double maxPrice,
                                 Model model) {
        try {
            List<Product> products;

            if (name != null && !name.trim().isEmpty()) {
                products = productService.findProductsByName(name);
            } else {
                products = productService.getAllProducts();
            }

            // Lọc theo giá nếu có
            if (minPrice != null || maxPrice != null) {
                products = products.stream()
                        .filter(p -> (minPrice == null || p.getUnitPrice() >= minPrice) &&
                                (maxPrice == null || p.getUnitPrice() <= maxPrice))
                        .toList();
            }

            model.addAttribute("products", products);
            model.addAttribute("searchName", name);
            model.addAttribute("minPrice", minPrice);
            model.addAttribute("maxPrice", maxPrice);

            System.out.println("Tìm kiếm - Số sản phẩm: " + (products != null ? products.size() : 0));
            return "listproducts";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi tìm kiếm: " + e.getMessage());
            return "error";
        }
    }

    // API endpoint để lấy dữ liệu JSON
    @GetMapping("/api/products")
    @ResponseBody
    public List<Product> getProductsApi() {
        return productService.getAllProducts();
    }

    // API tìm kiếm sản phẩm
    @GetMapping("/api/products/search")
    @ResponseBody
    public List<Product> searchProductsApi(@RequestParam(value = "name", required = false) String name) {
        if (name != null && !name.trim().isEmpty()) {
            return productService.findProductsByName(name);
        }
        return productService.getAllProducts();
    }

    // Test endpoint để kiểm tra
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        try {
            List<Product> products = productService.getAllProducts();
            return "Test OK - Số sản phẩm: " + (products != null ? products.size() : 0);
        } catch (Exception e) {
            return "Test ERROR: " + e.getMessage();
        }
    }
}