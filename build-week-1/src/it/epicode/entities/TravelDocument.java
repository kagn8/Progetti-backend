package it.epicode.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

//	Creazione della classe astratta TravelDocument
//	Creazione delle @NamedQuery per le ricerche 
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TravelDocuments", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "searchTravelDocumentFromDealer", query = "SELECT t FROM TravelDocument t WHERE t.dealer = :dealer AND t.issueDate >= :startDate AND t.issueDate <= :endDate")
@NamedQuery(name = "searchTicketValidateByTransport", query = "SELECT t FROM TravelDocument t WHERE t.convalidateBy = :transport")
@NamedQuery(name = "searchTicketValidationDateForDay", query = "SELECT t FROM TravelDocument t WHERE t.convalidationDate = :date")
@NamedQuery(name = "checkSeasonTicket", query = "SELECT t FROM SeasonTicket t WHERE t.id = :id")
@NamedQuery(name = "searchTicketValidationDateForPeriod", query = "SELECT t FROM TravelDocument t WHERE t.convalidationDate >= :startDate AND t.convalidationDate <= :endDate")
public abstract class TravelDocument {
	private int id;
	private LocalDate issueDate;
	private Dealer dealer;
	private Transport convalidateBy;
	private LocalDate convalidationDate;

	public TravelDocument(Dealer dealer) {

		this.issueDate = LocalDate.now();
		this.dealer = dealer;
	}

	public TravelDocument() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

//	Associazione @ManyToOne con l'entity Dealer
	@ManyToOne
	public Dealer getDealer() {
		return dealer;
	}

//	Associazione @ManyToOne con l'entity Transport
	@ManyToOne
	public Transport getConvalidateBy() {
		return convalidateBy;
	}

	public LocalDate getConvalidationDate() {
		return convalidationDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public void setConvalidateBy(Transport convalidateBy) {
		this.convalidateBy = convalidateBy;
	}

	public void setConvalidationDate(LocalDate convalidationDate) {
		this.convalidationDate = convalidationDate;
	}

	@Override
	public String toString() {
		return "TravelDocument [id=" + id + ", issueDate=" + issueDate + ", dealer=" + dealer + "]";
	}

}