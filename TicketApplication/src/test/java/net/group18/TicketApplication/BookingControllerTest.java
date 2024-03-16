package net.group18.TicketApplication;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("booking"));
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
    }
}
    

