package vn.com.iviettech.bai8.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.iviettech.bai8.Entity.Cart;
import vn.com.iviettech.bai8.Entity.Product;
import vn.com.iviettech.bai8.Service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
    public final ProductService productService;

    public CartController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public String showProduct(Model model){
        model.addAttribute("products", productService.showProduct());
        return "products";
    }


    @GetMapping("/add")
    public String addToCart(@RequestParam Long productId, HttpSession session) {
        Product product = productService.findById(productId);

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        cart.add(product, 1); // thêm 1 sản phẩm
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @GetMapping("/view")
    public String viewCart(HttpSession session, Model model) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        model.addAttribute("cart", cart);
        return "cart-view";
    }
}
