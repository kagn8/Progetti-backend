package it.epicode.Dao.interfaces;

import java.time.LocalDate;
import java.util.List;

import it.epicode.entities.Dealer;
import it.epicode.entities.Ticket;
import it.epicode.entities.Transport;
import it.epicode.entities.TravelDocument;

public interface TravelDocumentDaoInterface {

	public void addDocument(TravelDocument t);

	public void removeDocument(int id);

	public List<TravelDocument> searchTravelDocumentFromDealer(Dealer d, LocalDate startDate, LocalDate endDate);

	public List<TravelDocument> searchTicketValidateByTransport(Transport tr);

	public List<TravelDocument> searchTicketValidationDateForDay(LocalDate date);

	public List<TravelDocument> searchTicketValidationDateForPeriod(LocalDate startDate, LocalDate endDate);

	public void renewSeasonTicket(int id);

	public void covalidationTicket(Ticket t, Transport tr);

}
