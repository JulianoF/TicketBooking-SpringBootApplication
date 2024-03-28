package net.group18.TicketApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomePageController {

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/booking")
	public String booking(Model model) {
		return "booking";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/pastbooking")
	public String pastBooking(Model model) {
		return "pastbooking";
	}

	@GetMapping("/register")
	public String register(Model model) {
		return "registration";
	}
	
}