package vn.com.iviettech.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.com.iviettech.entity.CartEntity;
import vn.com.iviettech.entity.Orders;
import vn.com.iviettech.entity.Product;
import vn.com.iviettech.service.CartService;
import vn.com.iviettech.service.ProductService;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class CartController {


    private CartEntity cartEntity;


    private ProductService productService;


    private CartService cartService;

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId,
                            @RequestParam(defaultValue = "1") Integer quantity,
                            RedirectAttributes redirectAttributes) {
        Optional<Product> productOpt = productService.getProductById(productId);

        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            if (product.getQuantity() >= quantity) {
                cartEntity.addItem(product, quantity);
                redirectAttributes.addFlashAttribute("message", "Sản phẩm đã được thêm vào giỏ hàng!");
            } else {
                redirectAttributes.addFlashAttribute("error", "Không đủ hàng trong kho!");
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Sản phẩm không tồn tại!");
        }

        return "redirect:/products";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cart", cartEntity);
        return "cart";
    }

    @PostMapping("/cart/update")
    public String updateCart(@RequestParam Long productId,
                             @RequestParam Integer quantity,
                             RedirectAttributes redirectAttributes) {
        cartEntity.updateQuantity(productId, quantity);
        redirectAttributes.addFlashAttribute("message", "Giỏ hàng đã được cập nhật!");
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam Long productId,
                                 RedirectAttributes redirectAttributes) {
        cartEntity.removeItem(productId);
        redirectAttributes.addFlashAttribute("message", "Sản phẩm đã được xóa khỏi giỏ hàng!");
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String showCheckout(Model model) {
        if (cartEntity.isEmpty()) {
            return "redirect:/cart";
        }
        model.addAttribute("cart", cartEntity);
        return "checkout";
    }

    @PostMapping("/checkout")
    public String processCheckout(@RequestParam String customerName,
                                  @RequestParam String customerAddress,
                                  Model model,
                                  RedirectAttributes redirectAttributes) {
        if (cartEntity.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Giỏ hàng trống!");
            return "redirect:/cart";
        }

        try {
            Orders order = cartService.checkout(cartEntity, customerName, customerAddress);
            redirectAttributes.addFlashAttribute("message",
                    "Đặt hàng thành công! Mã đơn hàng: " + order.getId());
            return "redirect:/products";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra khi đặt hàng!");
            return "redirect:/checkout";
        }
    }
}