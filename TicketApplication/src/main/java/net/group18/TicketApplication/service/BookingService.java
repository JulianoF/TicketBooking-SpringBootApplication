package net.group18.TicketApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.group18.TicketApplication.entity.Booking;
import net.group18.TicketApplication.entity.Flight;
import net.group18.TicketApplication.entity.User;
import net.group18.TicketApplication.repository.BookingRepository;
import net.group18.TicketApplication.repository.FlightRepository;
import net.group18.TicketApplication.repository.UserRepository;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Flight> findFlightsByOrigin(String origin) {
        return flightRepository.findByOrigin(origin);
    }

    public List<Flight> findFlightsByDestination(String dest) {
        return flightRepository.findByDestination(dest);
    }

    public List<Flight> findFlightsByDepartureDate(LocalDate departDate) {
        return flightRepository.findByDepartureDate(departDate);
    }

    public List<Flight> findFlightsByOriginAndDepartureDate(String origin, LocalDate departureDate) {
        return flightRepository.findByOriginAndDepartureDate(origin, departureDate);
    }

    public List<Flight> findFlightsByDestinationAndDepartureDate(String destination, LocalDate departureDate) {
        return flightRepository.findByDestinationAndDepartureDate(destination, departureDate);
    }

    public List<Flight> findFlightsByDestinationAndOrigin(String destination, String origin) {
        return flightRepository.findByDestinationAndOrigin(destination, origin);
    }

    public Flight getFlightByOriginAndDestinationAndDepartureDate(String origin, String destination, LocalDate departureDate){
        return flightRepository.getFlightByOriginAndDestinationAndDepartureDate( origin, destination, departureDate);
    }
    public void createSingleFlightBooking(String origin, String destination, String departureDate, String departureTime, String totalDuration, String price) {
        LocalDate depart = LocalDate.parse(departureDate);

        Booking book = new Booking();
        book.setUser(userRepository.findByEmail("johndoe@example.com"));
        Flight temp = getFlightByOriginAndDestinationAndDepartureDate(origin,destination,depart);
        book.setDepartureFlight(temp);
        book.setReturnFlight(null);
        book.setBookingDate(depart);
        book.setBookingTime(departureTime);
        try {
            book.setTotalDurationMinutes(parseDuration(totalDuration));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        bookingRepository.save(book);

    }

    private static int parseDuration(String durationStr) throws ParseException {
        if (durationStr == null || durationStr.isEmpty()) {
          throw new ParseException("Invalid duration string: empty or null", 0);
        }
      
        String[] parts = durationStr.split(":");
        if (parts.length != 2) {
          throw new ParseException("Invalid duration format: must be HH:MM", 0);
        }
      
        try {
          int hours = Integer.parseInt(parts[0]);
          int minutes = Integer.parseInt(parts[1]);
      
          if (minutes < 0 || minutes > 59) {
            throw new ParseException("Invalid duration values: minutes must be between 0 and 59", 0);
          }
      
          return hours * 60 + minutes;
        } catch (NumberFormatException e) {
          throw new ParseException("Invalid duration format: contains non-numeric characters", 0);
        }
      }
      
    
}
