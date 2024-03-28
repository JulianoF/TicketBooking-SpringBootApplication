package net.group18.TicketApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @PostMapping("/loginUser")
    public String loginUser(@RequestParam("emailIn") String username, 
                            @RequestParam("password") String password, 
                            Model model) {

        return "redirect:/";
    }

    @PostMapping("/signupUser")
    public String signupUser(@RequestParam("emailIn") String username, 
                             @RequestParam("password") String password, 
                             Model model) {

        return "redirect:/login";
    }
}
