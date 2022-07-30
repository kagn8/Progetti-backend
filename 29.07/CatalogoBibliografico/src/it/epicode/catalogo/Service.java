package it.epicode.catalogo;

import java.util.HashMap;
import java.util.Map;

// CREIAMO UN SERVICE, CHE FUNGERà DA VERO E PROPRIO ARCHIVIO, IN QUANTO CONSERVA IL NOSTRO MAINCATALOG
public class Service {

//	DICHIARIAMO LA MAPPA CHE VOGLIAMO CREARE
	public Map<String, Catalog> mainCatalog = new HashMap<>();

//	GENERIAMO I VARI ELEMENTI CHE VOGLIAMO AGGIUNGERE AL NOSTRO CATALOGO
	Catalog book1 = new Book("1234", "Il Signore degli anelli", "2001", 963, "Tolkien", "Fantasy");
	Catalog book2 = new Book("5678", "Alla ricerca della valle incantata", "2000", 763, "Giorgio Mastrota",
			"Adventure");
	Catalog book3 = new Book("9101", "Tre gambe e un uomo", "2012", 523, "Rocco", "Dramatic");
	Catalog book4 = new Book("1121", "Crash Bandicoot 2: Cortex Strike back", "1998", 876, "Naughty dog", "Adventure");
	Catalog book5 = new Book("4156", "Dragon quest XI S - Echi di un'era perduta ", "2022", 126, "Akira Toriyama",
			"Fantasy");
	Catalog magazine1 = new Magazine("1321", "Chi", "1999", 23, Periodicity.MENSILE);
	Catalog magazine2 = new Magazine("2721", "Oggi", "2002", 43, Periodicity.SETTIMANALE);
	Catalog magazine3 = new Magazine("4381", "Gente", "2007", 51, Periodicity.SEMESTRALE);
	Catalog magazine4 = new Magazine("9321", "Topolino 2000", "2010", 22, Periodicity.MENSILE);
	Catalog magazine5 = new Magazine("4322", "The Amazing Spiderman", "2012", 63, Periodicity.SETTIMANALE);

//	DEFINIAMO UN METODO CHE CI PERMETTA DI AGGIUNGERE VELOCEMENTE GLI ELEMENTI AL NOSTRO MAINCATALOG
	public void addElement(Catalog element) {
		mainCatalog.put(element.getISBNcode(), element);
	}

//	DEFINIAMO UN METODO CHE CI PERMETTA DI RIMUOVERE VELOCEMENTE GLI ELEMENTI AL NOSTRO MAINCATALOG (MAI LANCIATO PERCHé NON RICHIESTO DALLA TRACCIA)
//	MA HO RITENUTO UTILE MANTENERLO
	public void deleteElement(Catalog element) {
		mainCatalog.remove(element.getISBNcode());
	}

//	DEFINIAMO UN COSTRUTTORE VUOTO (NON RICHIESTO DALLA TRACCIA) CHE POSSA PERMETTERCI DI ACCEDERE AL SERVICE PER VIE TRAVERSE
	public Service() {
		super();
	}

//	POPOLIAMO LA LISTA MAIN CATALOG GENERATA SOPRA
	public Map<String, Catalog> listMaker() {

//		LANCIANDO I VARI METODI ADD
		addElement(book1);
		addElement(book2);
		addElement(book3);
		addElement(book4);
		addElement(book5);
		addElement(magazine1);
		addElement(magazine2);
		addElement(magazine3);
		addElement(magazine4);
		addElement(magazine5);

		return mainCatalog;
	};

}
