package vn.com.iviettech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.iviettech.domain.User;

@RequestMapping("users")
@Controller
public class UserController {

    @GetMapping("register")
    public String showUserRegisterForm(Model model) {
        model.addAttribute("user", new User());

        return "user-register";
    }

    @PostMapping("register")
    public String regisUser(User user) {
        return "user-information";
    }
}
