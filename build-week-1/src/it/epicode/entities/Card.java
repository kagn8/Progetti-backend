package it.epicode.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//	Creazione Classe Card
@Entity
public class Card {

	private int cardNumber;
	private LocalDate releaseDate;
	private LocalDate expiredDate;

	private User user;

	private SeasonTicket seasonTicket;

	public Card(User user) {
		this.releaseDate = LocalDate.now();
		this.expiredDate = releaseDate.plusYears(1);
		this.user = user;
	}

	public Card() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCardNumber() {
		return cardNumber;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public LocalDate getExpiredDate() {
		return expiredDate;
	}

//	Associazione di tipo OneToOne con l'entità User
	@OneToOne
	public User getUser() {
		return user;
	}

//	Associazione di tipo OneToOne con l'entità SeasonTicket
	@OneToOne
	public SeasonTicket getSeasonTicket() {
		return seasonTicket;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setExpiredDate(LocalDate expiredDate) {
		this.expiredDate = expiredDate;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setSeasonTicket(SeasonTicket seasonTicket) {
		this.seasonTicket = seasonTicket;
	}

}