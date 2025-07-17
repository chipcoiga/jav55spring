package com.Bai7_shopping_cart.controller;

import com.Bai7_shopping_cart.model.CartEntity;
import com.Bai7_shopping_cart.model.CartItem;
import com.Bai7_shopping_cart.model.ProductEntity;
import com.Bai7_shopping_cart.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("session")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        CartEntity cart = getOrCreateCart(session);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") int productId, HttpSession session) {
        CartEntity cart = getOrCreateCart(session);
        ProductEntity product = productService.getProductById(productId);
        if (product != null) {
            cart.addItem(new CartItem(product, 1));
        }
        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam("productId") int productId, HttpSession session) {
        CartEntity cart = getOrCreateCart(session);
        cart.removeItem(productId);
        return "redirect:/cart";
    }

    @PostMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        CartEntity cart = getOrCreateCart(session);
        if (cart.getItems().isEmpty()) {
            model.addAttribute("message", "Giỏ hàng của bạn đang trống!");
            return "cart";
        }

        // Xử lý đặt hàng (step 5 sau)
        session.removeAttribute("cart");

        model.addAttribute("message", "Đặt hàng thành công!");
        return "checkout-success";
    }

    private CartEntity getOrCreateCart(HttpSession session) {
        CartEntity cart = (CartEntity) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartEntity();
            session.setAttribute("cart", cart);
        }
        return cart;
    }
}
