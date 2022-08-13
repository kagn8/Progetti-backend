package it.epicode.entities;

import javax.persistence.Entity;

//	Creazione sottoclasse Bus 
@Entity
public class Bus extends Transport {

	public Bus(int maxOccupacity) {
		super(maxOccupacity);
	}

	public Bus() {

	}
}