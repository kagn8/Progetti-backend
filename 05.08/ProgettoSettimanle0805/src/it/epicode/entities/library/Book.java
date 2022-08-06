package it.epicode.entities.library;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Book.QUERY_SELECT_SEARCH_AUTHOR, query = "SELECT a FROM Book a WHERE a.author = :autore")
public class Book extends Catalog {

	public static final String QUERY_SELECT_SEARCH_AUTHOR = "QUERY_SELECT_RICERCA_AUTORE";
	
	private String author;
	private String gender;

	public Book(String isbnCode, String title, String publicationYear, int numPage, String autore, String genere) {
		super(isbnCode, title, publicationYear, numPage);
		this.author = autore;
		this.gender = genere;
	}

	public Book(String codiceISBN, String titolo, String annoPublicazione, int nPagine) {
		super(codiceISBN, titolo, annoPublicazione, nPagine);
	}

	public Book() {

	}

	public Book(String autore, String genere) {
		this.author = autore;
		this.gender = genere;
	}

	public String getAutore() {
		return author;
	}

	public String getGenere() {
		return gender;
	}

	public void setAutore(String autore) {
		this.author = autore;
	}

	public void setGenere(String genere) {
		this.gender = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + author + ", genere=" + gender + ", codiceISBN=" + isbnCode + ", titolo=" + title
				+ ", annoPublicazione=" + publicationYear + ", nPagine=" + numPage + "]@";
	}

	public static Book fromStringFile(String stringFile) {
		String[] split = stringFile.split("@");

		return new Book(split[1], split[2], split[3], Integer.valueOf(split[4]), split[5], split[6]);
	}

}
