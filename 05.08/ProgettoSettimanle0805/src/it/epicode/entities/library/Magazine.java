package it.epicode.entities.library;

import javax.persistence.Entity;

@Entity
public class Magazine extends Catalog {

	Periodicity periodicity;

	public Magazine(String isbnCode, String title, String publicationYear, int numPage, Periodicity periodicità) {
		super(isbnCode, title, publicationYear, numPage);
		this.periodicity = periodicità;
	}

	public Magazine() {
		super();
	}

	public Magazine(String codiceISBN, String titolo, String annoPublicazione, int nPagine) {
		super(codiceISBN, titolo, annoPublicazione, nPagine);
	}

	public Magazine(Periodicity periodicità) {
		this();
		this.periodicity = periodicità;
	}

	public Periodicity getPeriodicità() {
		return periodicity;
	}

	public void setPeriodicità(Periodicity periodicità) {
		this.periodicity = periodicità;
	}

	@Override
	public String toString() {
		return "Rivista [periodicità=" + periodicity + ", codiceISBN=" + isbnCode + ", titolo=" + title
				+ ", annoPublicazione=" + publicationYear + ", nPagine=" + numPage + "]@";
	}

	public static Magazine fromStringFile(String stringFile) {
		String[] split = stringFile.split("@");
		Periodicity periodicita = Periodicity.valueOf(split[5]);

		return new Magazine(split[1], split[2], split[3], Integer.valueOf(split[4]), periodicita);
	}

}
