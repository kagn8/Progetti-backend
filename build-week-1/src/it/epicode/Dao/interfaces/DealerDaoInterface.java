package it.epicode.Dao.interfaces;

import it.epicode.entities.Dealer;

public interface DealerDaoInterface {

	public void addDealer(Dealer t);
	
	public void removeDealer(int id);
	
	public void editAtmStatus(int id);
	
}
