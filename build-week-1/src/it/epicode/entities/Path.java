package it.epicode.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//	Creazione della classe Path
@Entity
public class Path {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String start;
	private String ride;
	private int averageTime;
//	Definizione della relazione ManyToMany
	@ManyToMany(cascade = CascadeType.REMOVE)
	private Set<Transport> transport = new HashSet<Transport>();

	public Path(String start, String ride) {
		this.start = start;
		this.ride = ride;
		this.averageTime = 0;
	}

	public Path() {

	}

	public int getId() {
		return id;
	}

	public String getStart() {
		return start;
	}

	public String getRide() {
		return ride;
	}

	public int getAverageTime() {
		return averageTime;
	}

	public Set<Transport> getTransport() {
		return transport;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public void setRide(String ride) {
		this.ride = ride;
	}

	public void setAverageTime(int averageTime) {
		this.averageTime = averageTime;
	}

	public void setTransport(Transport transport) {
		this.transport.add(transport);
	}
}