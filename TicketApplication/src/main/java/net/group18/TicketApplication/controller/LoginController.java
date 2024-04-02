package net.group18.TicketApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.group18.TicketApplication.service.RegisterService;

import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RegisterService registerService;

    @PostMapping("/loginUser")
    public String loginUser(@RequestParam("emailIn") String username, 
                            @RequestParam("password") String password, 
                            Model model) {
        
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            SecurityContextHolder.getContext().setAuthentication(authentication);

			System.out.println(authentication);

            return "pastbooking";

        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("error", true);
            return "login";
        }
    }

    @PostMapping("/registeruser")
    public String signupUser(@RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             Model model) {

        registerService.registerUser(firstName, lastName, email, password);

        return "redirect:/login";
    }
}
