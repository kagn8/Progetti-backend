package it.epicode.entities;

import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.DiscriminatorType;

//	Creazione della classe astratta Transport
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Transport", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "searchTransportById", query = "SELECT t FROM Transport t WHERE t.id = :id")
public abstract class Transport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private Status status;

//	Associazione di tipo ManyToMany con l'entità Path
	@ManyToMany(mappedBy = "transport")
	private Set<Path> path;

	private int maxOccupacity;

	public Transport(int maxOccupacity) {
		this.status = Status.ONSERVICE;
		this.maxOccupacity = maxOccupacity;
	}

	public Transport() {

	}

	public int getId() {
		return id;
	}

	public Status getStatus() {
		return status;
	}

	public Set<Path> getPath() {
		return path;
	}

	public int getMaxOccupacity() {
		return maxOccupacity;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setPath(Path path) {
		this.path.add(path);
	}

	public void setMaxOccupacity(int maxOccupacity) {
		this.maxOccupacity = maxOccupacity;
	}

}