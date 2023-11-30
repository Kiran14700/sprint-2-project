package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.demo.entity.Booking;
import com.demo.service.BookingService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@GetMapping
	public java.util.List<Booking> getAllBookings() {

        return bookingService.getAllBookings();

    }

    @GetMapping("/{id}")
    public Optional<Booking> getBookings(@PathVariable (name="id") long id) {

        return bookingService.getBookings(id);
    }

    @PostMapping
    public void addBookings(@RequestBody Booking newmov) {
        bookingService.addBookings(newmov);
    }

    @DeleteMapping("/{id}")
    public void deleteBookings(@PathVariable (name="id") long id) {
        bookingService.deleteBookings(id);
    }

    @PutMapping("{id}")
    public void updateBookings(@RequestBody Booking updatedMov, @PathVariable (name="id") long id) {
        bookingService.updateBookings(updatedMov,id);
    }


}
