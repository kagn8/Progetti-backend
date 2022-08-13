package it.epicode.Dao.interfaces;

import it.epicode.entities.Transport;

public interface TransportDaoInterface {

	public void addTransport(Transport t);

	public void removeTransport(int id);

	public void editTrasportStatus(Transport t);

	public Transport searchTransportById(int idTransport);

}
