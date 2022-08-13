package it.epicode.entities;

import javax.persistence.Entity;

//	Creazione classe astratta AuthorizedDealer 
@Entity
public class AuthorizedDealer extends Dealer {

	private String name;

	public AuthorizedDealer(String adress, String city, String name) {
		super(adress, city);
		this.name = name;
	}

	public AuthorizedDealer() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}