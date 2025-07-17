package vn.com.iviettech.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.com.iviettech.entity.UserEntity;
import vn.com.iviettech.service.UserService;

@Controller
@RequestMapping("/users")
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@Valid @ModelAttribute("user") UserEntity user,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.save(user);
        return "redirect:/users/login";
    }
}
