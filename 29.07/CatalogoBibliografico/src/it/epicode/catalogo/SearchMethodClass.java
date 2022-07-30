package it.epicode.catalogo;

import java.util.Map;
import java.util.stream.Collectors;

// DEFINIAMO UNA CLASSE CHE IMPLEMENTA I VARI METODI DI RICERCA
public class SearchMethodClass implements SearchMathod {

//	INIZIALIZZIAMO UN CATALOGO VUOTO
	public Map<String, Catalog> mainCatalog;

//	DEFINIAMO UN COSTRUTTORE PER POPOLARE IL CATALOGO SOPRACITATO
	public SearchMethodClass(Map<String, Catalog> mainCatalog) {

		this.mainCatalog = mainCatalog;
	}

// 	DEFINIAMO I METODI SEARCH DEFINITI NELL'INTERFACCIA DOVE RACCOLGONO IL CATALOGO DEFINITO SOPRA AVVIANO UN FLUSSO ED APPLICANO I FILTRI RELATIVI 
//	PER RESTITUIRE LA MAPPA CHE LE INTERFACCIA CHIEDEVANO
//	INOLTRE IL METODO searchForAuthor HA BISOGNO ANCHE DI UN INSTANCEOF PER FILTRARE SOLO I LIBRI
	@Override
	public Map<String, Catalog> searchForAuthor(String author) {
		return mainCatalog.values().stream().filter(e -> e instanceof Book && ((Book) e).getAuthor().equals(author))
				.collect(Collectors.toMap(c -> c.getISBNcode(), c -> c));

	}

	@Override
	public Map<String, Catalog> searchForYear(String YEAR) {
		return mainCatalog.values().stream().filter(e -> e.getPublicationYear().equals(YEAR))
				.collect(Collectors.toMap(c -> c.getISBNcode(), c -> c));
	}

	@Override
	public Map<String, Catalog> searchForIsbn(String ISBN) {
		return mainCatalog.values().stream().filter(e -> e.getISBNcode().equals(ISBN))
				.collect(Collectors.toMap(c -> c.getISBNcode(), c -> c));
	}

}
