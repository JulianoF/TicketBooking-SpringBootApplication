package net.group18.TicketApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.format.annotation.DateTimeFormat;

import net.group18.TicketApplication.entity.Flight;
import net.group18.TicketApplication.service.BookingService;

@Controller
public class BookingController {

	@Autowired
    private BookingService flightService;

    @GetMapping("/search")
	public String lookup(@RequestParam("startDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") String startDateString,
						 @RequestParam("returnDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String returnDateString,
						 @RequestParam("searchInput") String searchInput,
						 Model model) {

		try{
			LocalDate startDate = LocalDate.parse(startDateString);
			LocalDate returnDate = LocalDate.parse(returnDateString);

					
			if (!startDate.isBefore(returnDate)) {
				model.addAttribute("invalidDateRange", true);
				return "booking";
			} 

			
			List<Flight> departingFlights = flightService.findFlightsByOriginAndDepartureDate(searchInput, startDate);

			List<Flight> returningFlights = flightService.findFlightsByDestinationAndDepartureDate(searchInput, returnDate);

			model.addAttribute("departingFlights", departingFlights);
			model.addAttribute("returningFlights", returningFlights);
		
			return "booking";

		} catch(DateTimeParseException e){

			List<Flight> originOnly = flightService.findFlightsByOrigin(searchInput);
			List<Flight> originDestOnly = flightService.findFlightsByDestination(searchInput);
			model.addAttribute("departingFlights", originOnly);
			model.addAttribute("returningFlights", originDestOnly);
			return "booking";
		}
	}

	
	@GetMapping("/createbooking")
	public String lookup(@RequestParam("origin") String origin,
						 @RequestParam("destination") String destination,
						 @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String departureDate,
						 @RequestParam("departureTime") String departureTime,
						 @RequestParam("totalDuration") String totalDuration,
						 @RequestParam("price") String price,
						 Model model) {



		return "booking";
	}
    
}
