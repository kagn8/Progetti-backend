package it.epicode.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

//	Creazione della classe Travel
//	Creazione delle @NamedQuery per le ricerche 
@Entity
@NamedQuery(name = "searchPathFromBus", query = "SELECT t FROM Travel t WHERE t.transport.id = :transId AND t.path.id = :pathId")
@NamedQuery(name = "searchForPath", query = "SELECT t FROM Travel t WHERE t.path.id = :pathId")
@NamedQuery(name = "searchTotalTicket", query = "SELECT t FROM Travel t WHERE t.path.id = :pathId")
public class Travel {

	private int id;

	private Path path;
	private Transport transport;
	private int effectiveTimeTravel;
	private LocalDate travelDate;

	public Travel(Path path, Transport trans, int effectiveTimeTravel) {
		this.travelDate = LocalDate.now();
		this.path = path;
		this.transport = trans;
		this.effectiveTimeTravel = effectiveTimeTravel;
	}

	public Travel() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

//	Associazione di tipo OneToOne con la classe Path
	@OneToOne
	public Path getPath() {
		return path;
	}

//	Associazione di tipo OneToOne con la classe Transport
	@OneToOne
	public Transport getTransport() {
		return transport;
	}

	public int getEffectiveTimeTravel() {
		return effectiveTimeTravel;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public void setEffectiveTimeTravel(int effectiveTimeTravel) {
		this.effectiveTimeTravel = effectiveTimeTravel;
	}
}