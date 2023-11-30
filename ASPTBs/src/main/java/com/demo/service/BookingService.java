package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.demo.entity.Booking;
import com.demo.exceptions.BookingException;
import com.demo.exceptions.BookingNotFoundException;
import com.demo.repository.BookingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;

	public List<Booking> getAllBookings() {

		ArrayList<Booking> allBookings = new ArrayList<>();
		bookingRepository.findAll().forEach(allBookings::add);

		return allBookings;
	}

	public Optional<Booking> getBookings(Long id) {

		return bookingRepository.findById(id);

	}

	public void addBookings(Booking booking) {
        try {
            bookingRepository.save(booking);
        } catch (Exception e) {
            // Handle the exception and throw a custom exception
            throw new BookingException("Error adding booking: " + e.getMessage());
        }
    }

    public void deleteBookings(Long id) {
        try {
            bookingRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where the booking with the given id doesn't exist
            throw new BookingNotFoundException("Booking with id " + id + " not found");
        } catch (Exception e) {
            // Handle other exceptions, e.g., database-related issues
            throw new BookingException("Error deleting booking: " + e.getMessage());
        }
    }

    public void updateBookings(Booking updatedBooking, Long id) {
        try {
            // Check if the booking with the given id exists before updating
            if (bookingRepository.existsById(id)) {
                updatedBooking.setId(id);
                bookingRepository.save(updatedBooking);
            } else {
                throw new BookingNotFoundException("Booking with id " + id + " not found");
            }
        } catch (Exception e) {
            // Handle other exceptions, e.g., database-related issues
            throw new BookingException("Error updating booking: " + e.getMessage());
        }
    }
}
