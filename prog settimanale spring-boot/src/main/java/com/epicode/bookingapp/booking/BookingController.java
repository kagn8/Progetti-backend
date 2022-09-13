package com.epicode.bookingapp.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/bookings")
@Slf4j
public class BookingController {

	@Autowired
	private BookingService bs;

	@PostMapping
	public void create(@RequestBody Booking b) {

		try {
			bs.create(b);
		} catch (Exception e) {
			log.error("Create failed");
		}
	}

	@GetMapping("/{id}")
	public Booking read(@PathVariable Long id) {

		try {
			return bs.read(id);
		} catch (Exception e) {
			log.error("Search failed");
			return new Booking();
		}
	}

	@PutMapping
	public void update(@RequestBody Booking b) {

		try {
			bs.update(b);
		} catch (Exception e) {
			log.error("Update failed");
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {

		try {
			bs.delete(id);
		} catch (Exception e) {
			log.error("Delete failed");
		}
	}
}
