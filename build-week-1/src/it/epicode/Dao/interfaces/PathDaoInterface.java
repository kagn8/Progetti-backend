package it.epicode.Dao.interfaces;

import it.epicode.entities.Path;
import it.epicode.entities.Transport;

public interface PathDaoInterface {

	public void addPath(Path p);
	
	public void removePath(int id);
	
	public void editPathStart(int id, String start);
	
	public void editPathEnd(int id, String end);
	
	public void editPathAverageTime(int id, int time);
	
	public void addTransportToPath(int id, Transport t);
	
}
