package net.group18.TicketApplication;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookingServiceTest {

    private  BookingService bookService; //service under test

    @BeforeEach
    public void setUp() {
        this.bookService = new BookingService();
    }

    @Test
    public void testBookingValidDay() {
        assertEquals(true, bookService.booking("2024-03-15", "2024-03-29"));
    }

    @Test
    public void testBookingInvalidEarlierDay() {
        assertEquals(false, bookService.booking("2024-03-15", "2024-03-01"));
    }

    @Test
    public void testBookingValidMonth() {
        assertEquals(true, bookService.booking("2024-03-15", "2024-04-01"));
    }

    @Test
    public void testBookingInvalidEarlierMonth() {
        assertEquals(false, bookService.booking("2024-03-15", "2024-02-28"));
    }

    @Test
    public void testBookingValidYear() {
        assertEquals(true, bookService.booking("2024-03-15", "2025-03-01"));
    }

    @Test
    public void testBookingInvalidEarlierYear() {
        assertEquals(false, bookService.booking("2024-03-15", "2023-03-29"));
    }

    @Test
    public void testBookingInvalidOOBMonth() {
        assertEquals(false, bookService.booking("2024-03-15", "2024-13-01"));
    }

    @Test
    public void testBookingInvalidOOBDay() {
        assertEquals(false, bookService.booking("2024-03-15", "2024-03-35"));
    }
}