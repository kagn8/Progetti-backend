package com.epicode.bookingapp.booking;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.bookingapp.user.User;
import com.epicode.bookingapp.workstation.Workstation;

@Configuration
public class BookingConfiguration {

	@Autowired @Qualifier("Workstation1") Workstation w1;
	@Autowired @Qualifier("Workstation2") Workstation w2;
	@Autowired @Qualifier("Workstation3") Workstation w3;
	@Autowired @Qualifier("Workstation4") Workstation w4;
	@Autowired @Qualifier("Workstation5") Workstation w5;
	
	//@Autowired @Qualifier("b1") Building b1;
	//@Autowired @Qualifier("b2") Building b2;
	
	@Autowired @Qualifier("user1") User u1;
	@Autowired @Qualifier("user2") User u2;
	@Autowired @Qualifier("user3") User u3;
	
	@Bean("booking1")
	public Booking booking1() {
		return new Booking(LocalDate.now(), w1, u1);
	}
	@Bean("booking2")
	public Booking booking2() {
		return new Booking(LocalDate.now(), w1, u2);
	}
	
	
	
}
