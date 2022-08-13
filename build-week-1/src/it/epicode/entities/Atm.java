package it.epicode.entities;

import javax.persistence.Entity;

//	Creazione classe Atm(Sottoclasse di Dealer)
@Entity
public class Atm extends Dealer {
//	Proprietà boolean per definire se l'atm è in funzione o non in funzione
	private boolean active;

	public Atm(boolean active) {
		super();
		this.active = active;
	}

	public Atm() {
		super();
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}