package vn.com.iviettech.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.iviettech.entity.ProductEntity;
import vn.com.iviettech.entity.CartItem;
import vn.com.iviettech.repository.ProductRepository;

import java.util.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long id, HttpSession session) {
        ProductEntity product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return "redirect:/products";
        }

        Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        CartItem item = cart.get(id);
        if (item == null) {
            cart.put(id, new CartItem(product, 1));
        } else {
            item.setQuantity(item.getQuantity() + 1);
        }

        session.setAttribute("cart", cart);
        return "redirect:/cart/view";
    }

    @GetMapping("/view")
    public String viewCart(HttpSession session, Model model) {
        Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        List<CartItem> cartItems = new ArrayList<>(cart.values());
        double total = cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", total);

        return "cart";
    }
}
