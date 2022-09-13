package com.epicode.bookingapp.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.epicode.bookingapp.booking.Booking;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@Table(name ="users" )
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String nome_completo;
	private String email;
	@OneToMany(mappedBy = "user")
	List<Booking> bookings = new ArrayList<>();
	
	public User(String username, String nome_completo, String email) {
		super();
		this.username = username;
		this.nome_completo = nome_completo;
		this.email = email;
	
	}
	
	
	
	
	
	
}
