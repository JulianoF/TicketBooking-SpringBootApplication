package net.group18.TicketApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.group18.TicketApplication.entity.Flight;
import net.group18.TicketApplication.repository.FlightRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private FlightRepository flightRepository;

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

}
