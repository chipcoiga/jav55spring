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
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {

        // Kiểm tra validation errors
        if (bindingResult.hasErrors()) {
            return "user-register";
        }

        // Kiểm tra mật khẩu xác nhận
        if (!userService.validatePasswordMatch(user.getPassword(), user.getRePassword())) {
            bindingResult.rejectValue("rePassword", "password.mismatch", "Mật khẩu xác nhận không khớp!");
            return "user-register";
        }

        // Kiểm tra email tồn tại
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            bindingResult.rejectValue("email", "email.exists", "Email đã tồn tại!");
            return "user-register";
        }

        // Kiểm tra username tồn tại
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            bindingResult.rejectValue("username", "username.exists", "Tên đăng nhập đã tồn tại!");
            return "user-register";
        }

        // Đăng ký user
        boolean isRegistered = userService.registerUser(user);

        if (isRegistered) {
            model.addAttribute("success", "Đăng ký thành công!");
            model.addAttribute("user", user);
            return "user-information";
        } else {
            model.addAttribute("error", "Có lỗi xảy ra trong quá trình đăng ký!");
            return "user-register";
        }
    }

    @GetMapping("information")
    public String showUserInformation(Model model) {
        return "user-information";
    }
}