package it.epicode.catalogo;

//CREIAMO UNA CLASSE MAGAZINE CHE ESTENDA LA CLASSE CTALOG
public class Magazine extends Catalog {

//	DEFINIAMO I PARAMETRI UNICI CHE APPARTENGONO ALLA CLASSE MAGAZINE
//	PERIODICITY DI TIPO PERIODICITY INDICA UN ELENCO FINITO DI VALORI CHE PUò ASSUMERE PERIODICITY
	Periodicity periodicity;

//	GENERIAMO UN COSTRUTTORE PER INIZIALIZZARE I VARI MAGAZINE
	public Magazine(String iSBNcode, String title, String publicationYear, int numOfPage, Periodicity periodicity) {
		super(iSBNcode, title, publicationYear, numOfPage);
		this.periodicity = periodicity;
	}
//	DEFINIAMO I GETTER E I SETTER
	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}
//	DEFINIAMO UN METODO TOSTRING OVVERO UN METODO CHE CI PERMETTA DI STAMPARE AGILMENTE UN OGGETTO APPARTENENTE A QUESTA CLASSE
	@Override
	public String toString() {
		return "Rivista [ codice ISBN: " + isbnCode + ", titolo: " + title + ", Anno di pubblicazione: "
				+ PublicationYear + ", N° di pagine: " + numOfPage + ", Periodicità: " + periodicity + " ]";
	}

}
