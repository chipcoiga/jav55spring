package vn.com.iviettech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.com.iviettech.domain.User;
import vn.com.iviettech.service.UserService;

import jakarta.validation.Valid;

@RequestMapping("users")
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("register")
    public String showUserRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "user-register";
    }

    @PostMapping("register")
    public String registerUser(@Valid User user, Model model) {


        if (!userService.validatePasswordMatch(user.getPassword(), user.getRePassword())) {
            model.addAttribute("error", "Mật khẩu xác nhận không khớp!");
            return "user-register";
        }


        if (!userService.isValidEmail(user.getEmail())) {
            model.addAttribute("error", "Email không hợp lệ!");
            return "user-register";
        }


        boolean isRegistered = userService.registerUser(user);

        if (isRegistered) {
            model.addAttribute("success", "Đăng ký thành công!");
            model.addAttribute("user", user);
            return "user-information";
        } else {
            model.addAttribute("error", "Username hoặc email đã tồn tại!");
            return "user-register";
        }
    }

    @GetMapping("information")
    public String showUserInformation(Model model) {
        return "user-information";
    }
}