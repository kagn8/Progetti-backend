package it.epicode.entities;

import javax.persistence.Entity;
//	Creazione della sottoclasse Tram
@Entity
public class Tram extends Transport {

	public Tram(int maxOccupacity) {
		super(maxOccupacity);
	}

	public Tram() {
 
	}
}