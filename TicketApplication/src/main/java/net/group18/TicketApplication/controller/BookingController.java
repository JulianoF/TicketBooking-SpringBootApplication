package net.group18.TicketApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    @GetMapping("/search")
	public String lookup(@RequestParam("startDate") String startDate,
						 @RequestParam("returnDate") String returnDate,
						 @RequestParam("searchInput") String searchInput,
						 Model model) {

		System.out.println(startDate+" "+returnDate+" "+searchInput);
		
		return "redirect:/booking";
	}
    
}
