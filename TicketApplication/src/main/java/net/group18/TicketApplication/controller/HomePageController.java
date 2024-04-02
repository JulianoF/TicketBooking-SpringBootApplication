package net.group18.TicketApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomePageController {

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

		return "pastbooking";
	}

	@GetMapping("/register")
	public String register(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication);
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

			System.out.println(username);

		}
		
		return "registration";
	}
	
}