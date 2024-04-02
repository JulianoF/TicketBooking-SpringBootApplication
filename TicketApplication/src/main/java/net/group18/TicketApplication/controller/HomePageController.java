package net.group18.TicketApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.group18.TicketApplication.entity.Booking;
import net.group18.TicketApplication.service.CreateBookingService;

@Controller
public class HomePageController {

	@Autowired
    private CreateBookingService bookService;

	@GetMapping("/")
	public String index(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication);
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

			System.out.println(username);

		}

		return "index";
	}

	@GetMapping("/booking")
	public String booking(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication);
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

			System.out.println(username);

		}

		return "booking";
	}

	@GetMapping("/login")
	public String login(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication);
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

			System.out.println(username);

		}

		return "login";
	}

	@GetMapping("/pastbooking")
	public String pastBooking(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication);
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

			System.out.println(username);

		}

		List<Booking> bookings = bookService.findByuser_id(Long.valueOf(3));
		model.addAttribute("bookings", bookings);

		return "pastbooking";
	}

	@GetMapping("/register")
	public String register(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication);
		System.out.println(authentication.getPrincipal());
		

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

			System.out.println(username);

		}
		
		return "registration";
	}
	
}