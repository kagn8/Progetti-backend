package it.epicode.catalogo;

import java.util.List;
import java.util.Map;

// DETTIAMO I METODI DI RICERCA CHE DOVRà AVERE LA CLASSE CHE IMPLEMENTERà L'INTERFACCIA
public interface SearchMathod {
//	DEFINIAMO I METODI CHE DOVRANNO RESTITUIRE UNA MAP<(K)STRING, (V)CATALOG> E IN INGRESSO RICHIEDONO UNA STRINGA CHE SETTERà IL FILTRO PER LA RICERCA 
	public Map<String, Catalog> searchForAuthor(String author);

	public Map<String, Catalog> searchForYear(String year);

	public Map<String, Catalog> searchForIsbn(String isbn);
}
