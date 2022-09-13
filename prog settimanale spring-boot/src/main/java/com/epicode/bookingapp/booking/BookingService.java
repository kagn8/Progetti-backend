package com.epicode.bookingapp.booking;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.bookingapp.workstation.Workstation;
import com.epicode.bookingapp.workstation.WorkstationRepository;
import com.epicode.bookingapp.workstation.WorkstationService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingService {

	@Autowired
	private BookingRepository br;

	public void create(Booking b) {
		List<Booking> booking = findByUserAndValidity(b.getUser().getId(), b.getValidity());

		if (booking == null || booking.size() == 0) {

			Integer w = findWorkstationByIdAndDate(b.getWorkstation().getId(), b.getValidity()).size();

			if (w == null || w < b.getWorkstation().getPartecipants()) {
				br.save(b);
			} else {
				log.error("the workstation is full");
			}

		} else {
			log.error("you have already booked for today");
		}
	}

	public Booking read(Long id) {
		return br.findById(id).get();
	}

	public void update(Booking building) {
		br.save(building);
	}

	public void delete(Long id) {
		br.deleteById(id);
	}

	public List<Booking> findByUserAndValidity(Long id, LocalDate validity) {
		return br.findByUserAndValidity(id, validity);
	}

	public List<Booking> findWorkstationByIdAndDate(Long id, LocalDate date) {
		return br.findByWorkstationAndValidity(id, date);
	}
}
