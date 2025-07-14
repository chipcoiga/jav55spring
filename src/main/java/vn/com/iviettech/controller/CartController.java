package vn.com.iviettech.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.com.iviettech.CartEntity;
import vn.com.iviettech.entity.OrderDetailEntity;
import vn.com.iviettech.entity.OrderEntity;
import vn.com.iviettech.entity.ProductEntity;
import vn.com.iviettech.repository.OrderDetailRepository;
import vn.com.iviettech.repository.OrderRepository;
import vn.com.iviettech.repository.ProductRepository;
import vn.com.iviettech.validate.CheckoutForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {

    private CartEntity cart;
    private ProductRepository productRepo;
    private OrderRepository orderRepo;
    private OrderDetailRepository orderDetailRepo;

    public CartController(CartEntity cart, ProductRepository productRepo,
                          OrderRepository orderRepo, OrderDetailRepository orderDetailRepo) {
        this.cart = cart;
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
        this.orderDetailRepo = orderDetailRepo;
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        Map<ProductEntity, Integer> cartView = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : cart.getItems().entrySet()) {
            productRepo.findById(entry.getKey()).ifPresent(product -> {
                cartView.put(product, entry.getValue());
            });
        }
        model.addAttribute("cartItems", cartView);

        if (!model.containsAttribute("checkoutForm")) {
            model.addAttribute("checkoutForm", new CheckoutForm());
        }

        return "cart";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id) {
        cart.addItem(id);
        return "redirect:/cart";
    }

    @PostMapping("/checkout")
    public String checkout(@ModelAttribute("checkoutForm") @Validated CheckoutForm form,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            Map<ProductEntity, Integer> cartView = new HashMap<>();
            for (Map.Entry<Long, Integer> entry : cart.getItems().entrySet()) {
                productRepo.findById(entry.getKey()).ifPresent(product -> {
                    cartView.put(product, entry.getValue());
                });
            }
            model.addAttribute("cartItems", cartView);
            return "cart";
        }

        OrderEntity order = new OrderEntity();
        order.setCustomerName(form.getName());
        order.setAddress(form.getAddress());

        List<OrderDetailEntity> details = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : cart.getItems().entrySet()) {
            ProductEntity product = productRepo.findById(entry.getKey()).orElseThrow();
            OrderDetailEntity detail = new OrderDetailEntity();
            detail.setProduct(product);
            detail.setQuantity(entry.getValue());
            detail.setOrder(order);
            details.add(detail);
        }
        order.setOrderDetails(details);
        orderRepo.save(order);
        cart.clear();
        return "redirect:/products";
    }
}
