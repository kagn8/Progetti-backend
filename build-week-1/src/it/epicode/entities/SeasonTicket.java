package it.epicode.entities;
 
import java.time.LocalDate;
 
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
//	Creazione della classe SeasonTicket
@Entity
public class SeasonTicket extends TravelDocument {
 
	private Card cardMember;
	private LocalDate expireDate;
	private TypeSeasonTicket type;
 
	public SeasonTicket(Dealer dealer, TypeSeasonTicket type, Card card) {
//	Distinzione dell'abbonamento tra mensile e settimanale attraverso il metodo .plusDays
		super(dealer);
		if (type == TypeSeasonTicket.WEEKLY) {
			this.expireDate = LocalDate.now().plusDays(7);
		} else {
			this.expireDate = LocalDate.now().plusDays(30);
		}
		this.cardMember = card;
		this.type = type;
	}
 
	public SeasonTicket() {
 
	}
//	Associazione di tipo OneToOne con l'entità Card
	@OneToOne
	public Card getCardMember() {
		return cardMember;
	}
 
	public LocalDate getExpireDate() {
		return expireDate;
	}
 
	@Enumerated(EnumType.STRING)
	public TypeSeasonTicket getType() {
		return type;
	}
 
	public void setCardMember(Card cardMember) {
		this.cardMember = cardMember;
	}
 
	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}
 
	public void setType(TypeSeasonTicket type) {
		this.type = type;
	}
 
	@Override
	public String toString() {
		return "SeasonTicket [cardMember=" + cardMember + ", expireDate=" + expireDate + ", type=" + type + "]";
	}
 
}