package it.epicode.entities.library;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Libreria", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = Catalog.QUERY_SELECT_SEARCH_ISBN, query = "SELECT a FROM Catalog a WHERE a.isbnCode = :isbn")
@NamedQuery(name = Catalog.QUERY_SELECT_SEARCH_YEAR, query = "SELECT a FROM Catalog a WHERE a.publicationYear = :anno")
@NamedQuery(name = Catalog.QUERY_SELECT_SEARCH_TITOLO, query = "SELECT a FROM Catalog a WHERE a.title LIKE :titolo")

public abstract class Catalog {

	public static final String QUERY_SELECT_SEARCH_ISBN = "QUERY_SELECT_RICERCA_ISBN";
	@Override
	public String toString() {
		return String.format("Catalog [id=%s, isbnCode=%s, title=%s, publicationYear=%s, numPage=%s]", id, isbnCode,
				title, publicationYear, numPage);
	}

	public static final String QUERY_SELECT_SEARCH_YEAR = "QUERY_SELECT_RICERCA_ANNO";
	public static final String QUERY_SELECT_SEARCH_TITOLO = "QUERY_SELECT_RICERCA_TITOLO";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String isbnCode;
	protected String title;
	protected String publicationYear;
	protected int numPage;

	public Catalog(String codiceISBN, String titolo, String annoPublicazione, int nPagine) {
		this.isbnCode = codiceISBN;
		this.title = titolo;
		this.publicationYear = annoPublicazione;
		this.numPage = nPagine;
	}

	public Catalog() {
	}

	public String getCodiceISBN() {
		return isbnCode;
	}

	public String getTitolo() {
		return title;
	}

	public String ricercaPerAnno() {
		return publicationYear;
	}

	public int getnPagine() {
		return numPage;
	}
	
	public int getId() {
		return id;
	}

	public void setCodiceISBN(String codiceISBN) {
		this.isbnCode = codiceISBN;
	}

	public void setTitolo(String titolo) {
		this.title = titolo;
	}

	public void setAnnoPublicazione(String annoPublicazione) {
		this.publicationYear = annoPublicazione;
	}

	public void setnPagine(int nPagine) {
		this.numPage = nPagine;
	}

}
