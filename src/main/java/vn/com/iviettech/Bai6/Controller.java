//package vn.com.iviettech.Bai5;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.crypto.spec.PSource;
//
//@org.springframework.stereotype.Controller
//@RequestMapping("/articles")
//public class Controller {
//    @GetMapping("/docs")
//    public String hello(Model model){
//        model.addAttribute("name", "Son");
//        model.addAttribute("otherName","Bill");
//        return "learn";
//    }
//    @GetMapping("/docs2")
//    public String print(Model model){
//        model.addAttribute("print","something");
//        return "learn";
//    }
//
//    @GetMapping("/docs3")
//    public String printNext(Model model, @RequestParam("name") String name){
//        System.out.println("name " + name);
//        model.addAttribute("name", name);
//        return "learn";
//    }
//}
