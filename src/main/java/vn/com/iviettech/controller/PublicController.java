package vn.com.iviettech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    @GetMapping("user")
    public String showUserPage() {
        return "user";
    }

    @GetMapping("admin")
    public String showAdminPage() {
        return "admin";
    }

    @GetMapping("public")
    public String showPublicPage() {
        return "public";
    }
}
