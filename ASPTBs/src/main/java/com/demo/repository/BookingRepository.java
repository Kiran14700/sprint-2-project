package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {
}
