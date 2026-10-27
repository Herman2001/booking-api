package se.herman.booking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.herman.booking_api.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
