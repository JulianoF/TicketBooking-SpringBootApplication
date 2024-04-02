package net.group18.TicketApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.group18.TicketApplication.entity.Booking;
import net.group18.TicketApplication.service.CreateBookingService;
import net.group18.TicketApplication.service.RegisterService;

import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private CreateBookingService bookService;

    @PostMapping("/loginUser")
    public String loginUser(@RequestParam("emailIn") String username, 
                            @RequestParam("password") String password, 
                            Model model) {
        
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            SecurityContextHolder.getContext().setAuthentication(authentication);

			System.out.println(authentication);

            List<Booking> bookings = bookService.findByuser_id(Long.valueOf(3));
		    model.addAttribute("bookings", bookings);
            System.out.println(bookings.size());

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
