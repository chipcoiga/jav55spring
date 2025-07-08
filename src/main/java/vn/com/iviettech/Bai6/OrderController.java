package vn.com.iviettech.Bai6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final InitData initData;
    private final OrderService service;

    public OrderController(InitData initData, OrderService service) {
        this.initData = initData;
        this.service = service;
    }

    @GetMapping("/init-data")
    public String showOrder(Model model){
        Order order = initData.createOrderWithOrderDetail();
        model.addAttribute("order", order);
        return "learn";
    }
    @GetMapping("/find")
    public String findById(@RequestParam("id") Long id, Model model){
        Order order = service.getOrderById(id);
        if (order == null) {
            model.addAttribute("message", "Không tìm thấy đơn hàng với ID: " + id);
            return "error";
        }
        model.addAttribute("order", order);
        return "learn";
    }
    @GetMapping("/search")
    public String getOrderDetails(@RequestParam("id")Long id, Model model){
        Order order = service.getAllOrderWithOrderDetail(id);
        model.addAttribute("order", order);
        return "learn";
    }

}
