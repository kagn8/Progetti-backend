package it.epicode.entities;

import javax.persistence.Entity;

//	Creazione della sottoclasse Ticket
@Entity
public class Ticket extends TravelDocument {

	private boolean validate;

	public Ticket(Dealer dealer) {
		super(dealer);
		this.validate = false;
	}

	public Ticket() {

	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	@Override
	public String toString() {
		return "Ticket [validate=" + validate + "]";
	}

}
