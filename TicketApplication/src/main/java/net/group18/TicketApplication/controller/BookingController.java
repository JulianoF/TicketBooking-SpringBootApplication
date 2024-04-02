package net.group18.TicketApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import net.group18.TicketApplication.entity.Booking;
import net.group18.TicketApplication.entity.Flight;
import net.group18.TicketApplication.service.BookingService;
import net.group18.TicketApplication.service.CreateBookingService;

@Controller
public class BookingController {

	@Autowired
    private BookingService flightService;

	@Autowired
    private CreateBookingService bookService;

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

	
	@PostMapping("/createbooking")
	public String create(@RequestParam("origin") String origin,
						 @RequestParam("destination") String destination,
						 @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String departureDate,
						 @RequestParam("departureTime") String departureTime,
						 @RequestParam("totalDuration") String totalDuration,
						 @RequestParam("price") String price,
						 @RequestParam(value = "returnFlight", required = false) boolean returnFlight,
						 Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

			System.out.println(username);

		}
		Flight flight = new Flight();
		flight.setOrigin(origin);
		flight.setDestination(destination);
		flight.setDepartureDate(LocalDate.parse(departureDate));
		flight.setDepartureTime(departureTime);
		flight.setTotalDuration(totalDuration);
		flight.setPrice(Double.parseDouble(price));

		if (returnFlight) {

			List<Flight> originOnly = flightService.findFlightsByDestinationAndOrigin(origin,destination);

			model.addAttribute("requireReturnFlight", true); 
			model.addAttribute("curFlight", flight); 
			model.addAttribute("returningFlights", originOnly);
			
			return "extraflight";

		} else {

			bookService.createSingleFlightBooking(origin, destination, departureDate, departureTime, totalDuration, price);
			
			List<Booking> bookings = bookService.findByuser_id(Long.valueOf(3));
			model.addAttribute("bookings", bookings);
		}
		
		return "pastbooking";
	}

	@PostMapping("/createroundtrip")
	public String createRound(@RequestParam("origin") String origin,
							 @RequestParam("destination") String destination,
							 @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String departureDate,
							 @RequestParam("departureTime") String departureTime,
							 @RequestParam("totalDuration") String totalDuration,
							 @RequestParam("price") String price,
							 @RequestParam("cOrigin") String cOrigin,
							 @RequestParam("cDestination") String cDestination,
							 @RequestParam("cDepartureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String cDepartureDate,
						 	 @RequestParam("cDepartureTime") String cDepartureTime,
							 @RequestParam("cTotalDuration") String cTotalDuration,
							 @RequestParam("cPrice") String cPrice,
							 Model model){


		bookService.createRoundTripBooking(origin, destination, departureDate, departureTime, totalDuration, price, cOrigin, cDestination, cDepartureDate, cDepartureTime, cTotalDuration, cPrice);
		List<Booking> bookings = bookService.findByuser_id(Long.valueOf(3));
		model.addAttribute("bookings", bookings);

		return "pastbooking";
	}


    
}
