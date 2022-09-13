package com.epicode.bookingapp.booking;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
	
	@Query("SELECT b FROM Booking b WHERE b.user.id =:id AND b.validity =:validity")
    public List<Booking> findByUserAndValidity(Long id, LocalDate validity);
	
	//@Query("SELECT b FROM Booking b WHERE b.workstation.id =:id AND b.dayOfBooking =:dayOfBooking")
	//public List<Booking> findByWorkstationAndDayOfBooking(Long id,LocalDate date);
	
	@Query("SELECT ele FROM Booking ele WHERE ele.workstation.id =:id AND ele.validity =:validity")
    public List<Booking> findByWorkstationAndValidity(Long id, LocalDate validity);

}
