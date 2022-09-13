package com.epicode.bookingapp.workstation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.epicode.bookingapp.booking.Booking;
import com.epicode.bookingapp.building.Building;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Workstation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private TypeWorkstation type;
	private Integer partecipants;
	@ManyToOne
	private Building building;
	@OneToMany(mappedBy = "workstation",cascade = CascadeType.PERSIST)
	List<Booking> bookings = new ArrayList<>();
	
	
	public Workstation(String description, TypeWorkstation type, Integer partecipants) {
		super();
		this.description = description;
		this.type = type;
		this.partecipants = partecipants;
		
	}
	
	
}
