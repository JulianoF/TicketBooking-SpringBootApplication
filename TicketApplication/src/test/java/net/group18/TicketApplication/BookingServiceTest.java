package net.group18.TicketApplication;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;

import net.group18.TicketApplication.entity.Flight;
import net.group18.TicketApplication.repository.FlightRepository;
import net.group18.TicketApplication.service.BookingService;

@SpringBootTest
public class BookingServiceTest {

    @InjectMocks
    private BookingService flightService;

    @Mock
    private FlightRepository flightRepository;

    @Test
    void testFindFlightsByOrigin() {

        String origin = "YYZ";
        List<Flight> expectedFlights = Arrays.asList(new Flight(), new Flight());

        when(flightRepository.findByOrigin(eq(origin))).thenReturn(expectedFlights);
       
        List<Flight> actualFlights = flightService.findFlightsByOrigin(origin);
      
        assertEquals(expectedFlights, actualFlights);
    }


    @Test
    void testGetFlightByOriginAndDestinationAndDepartureDate() {

        String origin = "LAX";
        String destination = "JFK";
        LocalDate departureDate = LocalDate.parse("2024-04-21");
        Flight expectedFlight = new Flight();

        when(flightRepository.getFlightByOriginAndDestinationAndDepartureDate(eq(origin), eq(destination), eq(departureDate)))
                .thenReturn(expectedFlight);

        Flight actualFlight = flightService.getFlightByOriginAndDestinationAndDepartureDate(origin, destination, departureDate);

        assertEquals(expectedFlight, actualFlight);
    }

    @Test
    void testFindByDestination(){
        String destination = "JFK";
        List<Flight> expectedFlights = Arrays.asList(new Flight(), new Flight());

        when(flightRepository.findByDestination(eq(destination)))
                .thenReturn(expectedFlights);
    
        List<Flight> actualFlights = flightService.findFlightsByDestination(destination);
      
        assertEquals(expectedFlights, actualFlights);
    }

    @Test
    void testFindByDepartureDate(){
        LocalDate departureDate = LocalDate.parse("2024-04-21");
        List<Flight> expectedFlights = Arrays.asList(new Flight(), new Flight());

        when(flightRepository.findByDepartureDate(eq(departureDate)))
                .thenReturn(expectedFlights);
    
        List<Flight> actualFlights = flightService.findFlightsByDepartureDate(departureDate);
      
        assertEquals(expectedFlights, actualFlights);
    }
  
    
    @Test
    void testFindByOriginAndDepartureDate(){
        String origin = "JFK";
        LocalDate departureDate = LocalDate.parse("2024-04-26");
        List<Flight> expectedFlights = Arrays.asList(new Flight(), new Flight());

        when(flightRepository.findByOriginAndDepartureDate(eq(origin),eq(departureDate)))
                .thenReturn(expectedFlights);
    
        List<Flight> actualFlights = flightService.findFlightsByOriginAndDepartureDate(origin,departureDate);
      
        assertEquals(expectedFlights, actualFlights);
    }

    @Test
    void testFindByDestinationAndDepartureDate(){
        String destination = "SFO";
        LocalDate departureDate = LocalDate.parse("2024-04-17");
        List<Flight> expectedFlights = Arrays.asList(new Flight(), new Flight());

        when(flightRepository.findByDestinationAndDepartureDate(eq(destination),eq(departureDate)))
                .thenReturn(expectedFlights);
    
        List<Flight> actualFlights = flightService.findFlightsByDestinationAndDepartureDate(destination,departureDate);
      
        assertEquals(expectedFlights, actualFlights);
    }

    @Test
    void testFindByDestinationAndOrigin(){
        String origin = "JFK";
        String destination = "LAX";
        List<Flight> expectedFlights = Arrays.asList(new Flight(), new Flight());

        when(flightRepository.findByDestinationAndOrigin(eq(destination),eq(origin)))
                .thenReturn(expectedFlights);
    
        List<Flight> actualFlights = flightService.findFlightsByDestinationAndOrigin(destination,origin);
      
        assertEquals(expectedFlights, actualFlights);
    }
    
}