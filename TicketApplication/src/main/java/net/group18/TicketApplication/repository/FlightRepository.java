package net.group18.TicketApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import net.group18.TicketApplication.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
       
    List<Flight> findByOrigin(String origin);

    List<Flight> findByDestination(String dest);

    List<Flight> findByDepartureDate(LocalDate departDate);

    List<Flight> findByOriginAndDepartureDate(String origin, LocalDate departureDate);

    List<Flight> findByDestinationAndDepartureDate(String destination, LocalDate departureDate);    

}