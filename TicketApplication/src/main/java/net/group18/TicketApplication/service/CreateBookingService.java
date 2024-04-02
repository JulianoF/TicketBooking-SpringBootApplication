package net.group18.TicketApplication.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.group18.TicketApplication.entity.Booking;
import net.group18.TicketApplication.entity.Flight;
import net.group18.TicketApplication.repository.BookingRepository;
import net.group18.TicketApplication.repository.FlightRepository;
import net.group18.TicketApplication.repository.UserRepository;

@Service
public class CreateBookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Booking> findByuser_id(Long user_id){
      return bookingRepository.findByuser_id(user_id);
    }

     public void createSingleFlightBooking(String origin, String destination, String departureDate, String departureTime, String totalDuration, String price) {
        LocalDate depart = LocalDate.parse(departureDate);

        Booking book = new Booking();
        book.setUser(userRepository.findByEmail("johndoe@example.com"));
        Flight temp = flightRepository.getFlightByOriginAndDestinationAndDepartureDate(origin,destination,depart);
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

    public void createRoundTripBooking(String origin,
                                      String destination,
                                      String departureDate,
                                      String departureTime,
                                      String totalDuration,
                                      String price,
                                      String cOrigin,
                                      String cDestination,
                                      String cDepartureDate,
                                      String cDepartureTime,
                                      String cTotalDuration,
                                      String cPrice){

        

        LocalDate depart = LocalDate.parse(departureDate);
        LocalDate cDepart = LocalDate.parse(cDepartureDate);
        Booking book = new Booking();
        book.setUser(userRepository.findByEmail("johndoe@example.com"));
        Flight temp = flightRepository.getFlightByOriginAndDestinationAndDepartureDate(origin,destination,depart);
        Flight temp2 = flightRepository.getFlightByOriginAndDestinationAndDepartureDate(cOrigin,cDestination,cDepart);
        book.setDepartureFlight(temp);
        book.setReturnFlight(temp2);
        book.setBookingDate(depart);
        book.setBookingTime(departureTime);
        try {
            book.setTotalDurationMinutes((parseDuration(totalDuration)+parseDuration(cTotalDuration)));
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
