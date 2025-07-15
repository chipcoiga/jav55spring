package vn.com.iviettech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("login")
    public String showLoginPage(Model model) {
        model.addAttribute("username", "");
        model.addAttribute("password", "");
        return "login";
    }
}
