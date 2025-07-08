package vn.com.iviettech.domain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @GetMapping("/register")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "userRegister";
    }

    @PostMapping("/register")
    public String register(User user){
//        model.addAttribute("user",user);
        return "user";
    }
}
