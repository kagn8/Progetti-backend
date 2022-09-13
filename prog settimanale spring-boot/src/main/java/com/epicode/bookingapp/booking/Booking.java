package com.epicode.bookingapp.booking;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.epicode.bookingapp.user.User;
import com.epicode.bookingapp.workstation.Workstation;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate validity;
	@ManyToOne
	private Workstation workstation;
	@ManyToOne
	private User user;
	
	public Booking(LocalDate validity, Workstation workstation, User user) {
		super();
		this.validity = validity;
		this.workstation = workstation;
		this.user = user;
	}
	
	
	
	
}
