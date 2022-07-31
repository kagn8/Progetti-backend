package it.epicode.catalogo;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// IMPORTARE GLI ADDON ESTERNI O L'APP POTREBBE NON FUNZIONARE CORRETTAMENTE
public class ArchiveMain {
	
//	INIZIALIZZIAMO UN LOGGER
	private static final Logger Log = LoggerFactory.getLogger(ArchiveMain.class);

	public static void main(String[] args) throws IOException {

//		DEFINIAMO UN CATALOGO LANCIANDO IL METODO LISTMAKER INIZIALIZZANDO IL SERVICE
		Map<String, Catalog> mainCatalog = new Service().listMaker();

//		INIZIALIZZIAMO LA CLASSE CHE CONTIENE TUTTI I METODI DI RICERCA, PASSANDO NEL COSTRUTTORE IL MAINCATALOG INIZIALIZZATO PRECEDENTEMENTE
		SearchMathod search = new SearchMethodClass(mainCatalog);
//		INIZIALIZZIAMO LA CLASSE CHE CONTIENE TUTTI I METODI DI LETTTURA E SCRITTURA SU FILE ESTERNI, PASSANDO NEL COSTRUTTORE IL MAINCATALOG INIZIALIZZATO PRECEDENTEMENTE
		ImportExportData writeAndReadToExternalFile = new ImportExportDataClass(mainCatalog);

		Log.info("CATALOGO INIZIALE COMPLETO:");
//		STAMPIAMO IL MAINCATALOG
		mainCatalog.forEach((k, v) -> Log.info(k + " " + v));

		Log.info("----------");
		Log.info("RICERCA PER ANNO (2012):");
//		ESEGUIAMO UNA RICERCA PER ANNO ED ASSEGNAMO IL RISULTATO AL CATALOGO CREATO SOLO PER QUESTO SCOPO
		Map<String, Catalog> catalogYear = search.searchForYear("2012");
//		STAMPIAMO IL RISULTATO
		catalogYear.forEach((k, v) -> Log.info(k + " " + v));
		Log.info("----------");
		Log.info("RICERCA PER AUTORE (Tolkien):");
//		ESEGUIAMO UNA RICERCA PER AUTORE ED ASSEGNAMO IL RISULTATO AL CATALOGO CREATO SOLO PER QUESTO SCOPO
		Map<String, Catalog> catalogAuthor = search.searchForAuthor("Tolkien");
//		STAMPIAMO IL RISULTATO
		catalogAuthor.forEach((k, v) -> Log.info(k + " " + v));
		Log.info("----------");
		Log.info("RICERCA PER ISBN (9101):");
//		ESEGUIAMO UNA RICERCA PER ISBN ED ASSEGNAMO IL RISULTATO AL CATALOGO CREATO SOLO PER QUESTO SCOPO
		Map<String, Catalog> catalogIsbn = search.searchForIsbn("9101");
//		STAMPIAMO IL RISULTATO
		catalogIsbn.forEach((k, v) -> Log.info(k + " " + v));

		
//		SCRIVIAMO IL CONTENUTO DEL MAIN CATALOG ALL'INTERNO DEL FILE CATALOG.TXT
		writeAndReadToExternalFile.writeToExternalFile();
		Log.info("----------");
		Log.info("Riscrittura nei log dei dati letti da file");
//		LEGGIAMO IL FILE CATALOG.CSV CHE ABBIAMO SCRITTO PRECEDENTEMENTE E NE STAMPIAMO IL CONTENUTO IN CONSOLE
		Map<String, Catalog> listaDatiLetti = writeAndReadToExternalFile.readToExternalFile();
		listaDatiLetti.forEach((k, v) -> System.out.println(v));
	}
}
