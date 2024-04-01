package net.group18.TicketApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.group18.TicketApplication.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Define custom query methods if needed
}
