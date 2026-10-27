package se.herman.booking_api.service;

import org.springframework.stereotype.Service;
import se.herman.booking_api.entity.Booking;
import se.herman.booking_api.entity.BookingStatus;
import se.herman.booking_api.repository.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> findById(Long id){
        return bookingRepository.findById(id);
    }

    public Booking create(Booking booking){
        booking.setId(null);
        if (booking.getStatus() == null) {
            booking.setStatus(BookingStatus.PENDING);
        }
        return bookingRepository.save(booking);
    }

    public Optional<Booking> update(Long id, Booking updatedBooking){
        return bookingRepository.findById(id).map(existing -> {
            existing.setName(updatedBooking.getName());
            existing.setEmail(updatedBooking.getEmail());
            existing.setDateTime(updatedBooking.getDateTime());
            existing.setNumberOfPeople(updatedBooking.getNumberOfPeople());
            if (updatedBooking.getStatus() != null) {
                existing.setStatus(updatedBooking.getStatus());
            }
            return bookingRepository.save(existing);
        });
    }

    public boolean deleteById(Long id) {
        if (!bookingRepository.existsById(id)) {
            return false;
        }
        bookingRepository.deleteById(id);
        return true;
    }
}
