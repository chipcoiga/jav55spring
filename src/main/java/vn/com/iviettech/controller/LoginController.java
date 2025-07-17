package vn.com.iviettech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.iviettech.entity.UserEntity;
import vn.com.iviettech.service.UserService;

@Controller
@RequestMapping("/users")
public class LoginController {


    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("user") UserEntity user, Model model) {
        if (userService.checkLogin(user.getName(), user.getPassword())) {
            return "redirect:/products";
        }
        model.addAttribute("error", "Sai tên hoặc mật khẩu!");
        return "login";
    }
}
