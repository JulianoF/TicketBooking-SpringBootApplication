   
package net.group18.TicketApplication;

import static org.mockito.Mockito.*;

import org.assertj.core.api.LocalDateAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import net.group18.TicketApplication.controller.BookingController;
import net.group18.TicketApplication.controller.HomePageController;
import net.group18.TicketApplication.entity.Flight;
import net.group18.TicketApplication.service.BookingService;
import net.group18.TicketApplication.service.CreateBookingService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HomePageController.class)
public class BookingControllerTest {

    @Autowired
    private MockMvc mvc;

/*     @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"));
    }

    @Test
    public void postBooking() throws Exception {
    this.mvc.perform(post("/book"))
        .andExpect(status().isOk());
    }
    @Test
    public void viewBooking() throws Exception {
    this.mvc.perform(post("/view"))
        .andExpect(status().isOk());
    }
    
    @Test
    public void testBookingPage() throws Exception {
        this.mvc.perform(get("/booking"))
            .andExpect(status().isOk())
            .andExpect(view().name("bookingForm"))
            .andExpect(model().attribute("bookingDetails", notNullValue()));
    }
    @Test
    public void testBookingSubmission() throws Exception {
        this.mvc.perform(post("/booking/submit")
                        .param("flightNumber", "Air123")
                        .param("passengerName", "John Doe")
                        .param("seatNumber", "F120"))
            .andExpect(status().isOk())
            .andExpect(view().name("bookingConfirmation"))
            .andExpect(model().attribute("confirmationNumber", notNullValue()));
    }
    @Test
    public void testBookingCancellation() throws Exception {
        this.mvc.perform(post("/booking/cancel")
                        .param("confirmationNumber", "ZL11"))
            .andExpect(status().isOk())
            .andExpect(view().name("cancellationConfirmation"))
            .andExpect(model().attribute("cancellationMessage", notNullValue()));
    }  */
/*     
@Test
    public void testCreateOneWayBooking_Success() {
        String origin = "Origin";
        String destination = "Destination";
        String departureDate = "2024-04-02";
        String departureTime = "12:00";
        String totalDuration = "2h";
        String price = "100.00";

        Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setDepartureDate(LocalDateAssert.parse(departureDate));
        flight.setDepartureTime(departureTime);
        flight.setTotalDuration(totalDuration);
        flight.setPrice(Double.parseDouble(price));

        when(flightService.createSingleFlightBooking(origin, destination, departureDate, departureTime, totalDuration, price)).thenReturn(flight);

        
        String result = bookingController.create(origin, destination, departureDate, departureTime, totalDuration, price, false, model);

        
        verify(flightService).createSingleFlightBooking(origin, destination, departureDate, departureTime, totalDuration, price);
        verifyNoInteractions(model); // No interactions with the model
        assert(result.equals("pastbooking"));
    }
    
    @Test
    public void testCreateOneWayBooking_WithReturnFlight() {
        
        String origin = "Origin";
        String destination = "Destination";
        String departureDate = "2024-04-02";
        String departureTime = "12:00";
        String totalDuration = "2h";
        String price = "100.00";

        List<Flight> originOnlyFlights = new ArrayList<>();
        Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setDepartureDate(LocalDate.parse(departureDate));
        flight.setDepartureTime(departureTime);
        flight.setTotalDuration(totalDuration);
        flight.setPrice(Double.parseDouble(price));
        originOnlyFlights.add(flight);

        when(flightService.findFlightsByDestinationAndOrigin(origin, destination)).thenReturn(originOnlyFlights);

       
        String result = bookingController.create(origin, destination, departureDate, departureTime, totalDuration, price, true, model);

       
        verify(flightService, never()).createSingleFlightBooking(origin, destination, departureDate, departureTime, totalDuration, price);
        verify(model).addAttribute("requireReturnFlight", true);
        verify(model).addAttribute("curFlight", flight);
        verify(model).addAttribute("returningFlights", originOnlyFlights);
        assert(result.equals("extraflight"));
    } */
}


