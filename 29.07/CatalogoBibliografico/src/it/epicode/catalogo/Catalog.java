package it.epicode.catalogo;

// DEFINIAMO UNA CLASSE ASTRATTA CATALOG CHE RACCOGLIERà TUTTI I PARAMETRI COMUNI ALLE DUE SOTTOCLASSI
public abstract class Catalog {

//	DEFINIAMO I PARAMETRI
	protected String isbnCode;
	protected String title;
	protected String PublicationYear;
	protected int numOfPage;

//	DEFINIAMO UN COSTRUTTORE
	public Catalog(String iSBNcode, String title, String publicationYear, int numOfPage) {
		this.isbnCode = iSBNcode;
		this.title = title;
		this.PublicationYear = publicationYear;
		this.numOfPage = numOfPage;
	}

//	GENERIAMO I GETTER E I SETTER
	public String getISBNcode() {
		return isbnCode;
	}

	public void setISBNcode(String iSBNcode) {
		isbnCode = iSBNcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublicationYear() {
		return PublicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		PublicationYear = publicationYear;
	}

	public int getNumOfPage() {
		return numOfPage;
	}

	public void setNumOfPage(int numOfPage) {
		this.numOfPage = numOfPage;
	}

}
