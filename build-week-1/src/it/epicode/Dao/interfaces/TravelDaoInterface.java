package it.epicode.Dao.interfaces;

import it.epicode.entities.Travel;

public interface TravelDaoInterface {

	public void addTravel(Travel t);

	public void removeTravel(int id);

	public int searchPathFromBus(int idTransport, int idPath);

	public int calcolateEffectiveTime(int idPath);
	
}
