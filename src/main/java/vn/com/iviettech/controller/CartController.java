package vn.com.iviettech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.iviettech.cart.CartEntity;
import vn.com.iviettech.entity.Product;
import vn.com.iviettech.repository.ProductRepository;
import vn.com.iviettech.service.OrderService;

import java.util.*;

@Controller
@SessionAttributes("cart")
public class CartController {

    @Autowired
    private CartEntity cart;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderService orderService;

    @GetMapping("/cart")
    public String showCart(Model model) {
        Map<Long, Integer> items = cart.getItems();
        Map<Product, Integer> cartItems = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : items.entrySet()) {
            productRepo.findById(entry.getKey()).ifPresent(product ->
                    cartItems.put(product, entry.getValue()));
        }
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable("id") Long id) {
        cart.add(id);
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable("id") Long id) {
        cart.remove(id);
        return "redirect:/cart";
    }

    @PostMapping("/cart/update")
    public String updateCart(@RequestParam Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey().startsWith("qty_")) {
                Long productId = Long.parseLong(entry.getKey().substring(4));
                int qty = Integer.parseInt(entry.getValue());
                cart.changeQuantity(productId, qty);
            }
        }
        return "redirect:/cart";
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam String customerName,
                           @RequestParam String address,
                           Model model) {
        orderService.checkout(customerName, address, cart.getItems());
        cart.clear();
        return "checkout";
    }
}
