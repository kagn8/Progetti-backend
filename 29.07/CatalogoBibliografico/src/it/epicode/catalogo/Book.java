package it.epicode.catalogo;

// CREIAMO UNA CLASSE BOOK CHE ESTENDA LA CLASSE CTALOG
public class Book extends Catalog {

//	DEFINIAMO I PARAMETRI UNICI CHE APPARTENGONO ALLA CLASSE BOOK
	private String author;
	private String genre;

//	GENERIAMO UN COSTRUTTORE PER INIZIALIZZARE I VARI LIBRI
	public Book(String iSBNcode, String title, String publicationYear, int numOfPage, String author, String genre) {
		super(iSBNcode, title, publicationYear, numOfPage);
		this.author = author;
		this.genre = genre;
	}
//	DEFINIAMO I GETTER E I SETTER
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

//	DEFINIAMO UN METODO TOSTRING OVVERO UN METODO CHE CI PERMETTA DI STAMPARE AGILMENTE UN OGGETTO APPARTENENTE A QUESTA CLASSE
	@Override
	public String toString() {
		return isbnCode + ";" + title + ";" + publicationYear + ";" + numOfPage + ";" + author + ";" + genre;
	}
}
