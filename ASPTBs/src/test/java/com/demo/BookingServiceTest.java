package com.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import com.demo.entity.Booking;
import com.demo.exceptions.BookingNotFoundException;
import com.demo.repository.BookingRepository;
import com.demo.service.BookingService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

//    @Test
//    void testAddBookings() {
//        Booking bookingToAdd = new Booking();
//        doNothing().when(bookingRepository).save(any(Booking.class));
//
//        assertDoesNotThrow(() -> bookingService.addBookings(bookingToAdd));
//        verify(bookingRepository, times(1)).save(bookingToAdd);
//    }

    @Test
    void testDeleteBookings() {
        Long bookingIdToDelete = 1L;
        doNothing().when(bookingRepository).deleteById(eq(bookingIdToDelete));

        assertDoesNotThrow(() -> bookingService.deleteBookings(bookingIdToDelete));
        verify(bookingRepository, times(1)).deleteById(bookingIdToDelete);
    }

    @Test
    void testDeleteBookingsNotFound() {
        Long bookingIdToDelete = 1L;
        doThrow(new EmptyResultDataAccessException(1)).when(bookingRepository).deleteById(eq(bookingIdToDelete));

        BookingNotFoundException exception = assertThrows(BookingNotFoundException.class,
                () -> bookingService.deleteBookings(bookingIdToDelete));
        assertEquals("Booking with id " + bookingIdToDelete + " not found", exception.getMessage());

        verify(bookingRepository, times(1)).deleteById(bookingIdToDelete);
    }

    @Test
    void testUpdateBookings() {
        Long bookingIdToUpdate = 1L;
        Booking updatedBooking = new Booking();
        when(bookingRepository.existsById(eq(bookingIdToUpdate))).thenReturn(true);
        when(bookingRepository.save(any(Booking.class))).thenReturn(updatedBooking);

        assertDoesNotThrow(() -> bookingService.updateBookings(updatedBooking, bookingIdToUpdate));
        verify(bookingRepository, times(1)).existsById(bookingIdToUpdate);
        verify(bookingRepository, times(1)).save(updatedBooking);
    }

//    @Test
//    void testUpdateBookingsNotFound() {
//        Long bookingIdToUpdate = 1L;
//        Booking updatedBooking = new Booking();
//        when(bookingRepository.existsById(eq(bookingIdToUpdate))).thenReturn(false);
//
//        BookingNotFoundException exception = assertThrows(BookingNotFoundException.class,
//                () -> bookingService.updateBookings(updatedBooking, bookingIdToUpdate));
//        assertEquals("Booking with id " + bookingIdToUpdate + " not found", exception.getMessage());
//
//        verify(bookingRepository, times(1)).existsById(bookingIdToUpdate);
//    }

    @Test
    void testGetBookings() {
        Long bookingIdToGet = 1L;
        Booking expectedBooking = new Booking();
        when(bookingRepository.findById(eq(bookingIdToGet))).thenReturn(Optional.of(expectedBooking));

        Optional<Booking> result = bookingService.getBookings(bookingIdToGet);
        assertTrue(result.isPresent());
        assertEquals(expectedBooking, result.get());

        verify(bookingRepository, times(1)).findById(bookingIdToGet);
    }
}

