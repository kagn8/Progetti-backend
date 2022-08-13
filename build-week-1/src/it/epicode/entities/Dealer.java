package it.epicode.entities;
 
import java.util.List;
 
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
//	Creazione della classe Dealer
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Dealers", discriminatorType = DiscriminatorType.STRING)
public abstract class Dealer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adress;
	private String city;
//	Associazione di tipo OneToMany con l'entità Dealer 
	@OneToMany(mappedBy = "dealer")
	private List<TravelDocument> travelDocument;
 
	public Dealer(String adress, String city) {
		super();
		this.adress = adress;
		this.city = city;
 
	}
 
	public Dealer() {
 
	}
 
	public List<TravelDocument> getTravelDocument() {
		return travelDocument;
	}
 
	public String getAdress() {
		return adress;
	}
 
	public String getCity() {
		return city;
	}
 
	public void setTravelDocument(List<TravelDocument> travelDocument) {
		this.travelDocument = travelDocument;
	}
 
	public void setAdress(String adress) {
		this.adress = adress;
	}
 
	public void setCity(String city) {
		this.city = city;
	}
 
}