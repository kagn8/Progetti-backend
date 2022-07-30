package it.epicode.catalogo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

// GENERIAMO UNA CLASSE CHE IMPLEMENTA L'INTERFACCIA ImportExportData
public class ImportExportDataClass implements ImportExportData {

//	INIZIALIZZIAMO UNA LISTA
	public Map<String, Catalog> mainCatalog;

//	GENERIAMO UN COSTRUTTORE CHE PERMETTE A CHI LO LANCIA DI POPOLARE LA LISTA SOPRACITATA
	public ImportExportDataClass(Map<String, Catalog> mainCatalog) {

		this.mainCatalog = mainCatalog;
	}

//	ANDIAMO A DEFINIRE IL METODO WRITE DICHIARATO NELL'INTERFACCIA
	@Override
	public void writeToExternalFile() throws IOException {
//		INIZIALIZZIAMO UNA STRINGA VUOTA
		String catalogToText = "";

//		GENERIAMO UN FOR CHE ANDRA AD AGIRE SUL MAIN CATALOG E PER OGNI VALORE AL SUO INTERNO
		for (Catalog cat : mainCatalog.values()) {
//			GENERA UNA STRINGA E LA AGGIUNGE ALLA VARIABILE STRINGA VUOTA GENERATA IN QUESTO METODO SEGUITA DA ";" E "\N" CHE MANDA A CAPO TRA UNA RIGA E L'ALTRA
			catalogToText += (cat.toString() + ";" + "\n");
			
		}
//		CREIAMO IL FILE DI TESTO CATALOG.TXT NELLA CARTELLA DEL NOSTRO PROGETTO
		File catalogFile = new File("./catalog.txt");

//		RACCOGLIAMO IL CONTENUTO DELLA STRINGA CREATA PRECEDENTEMENTE E LA SCRIVIAMO NEL FILE APPENA GENERATO, SECONDO IL SET DI CARATTERI "UFT-8"
		FileUtils.writeStringToFile(catalogFile, catalogToText, "UTF-8");

	}

//	ANDIAMO A DEFINIRE IL METODO READ DICHIARATO NELL'INTERFACCIA
	@Override
	public List<String> readToExternalFile() throws IOException {
//		GENERIAMO UNA NUOVA LISTA
		List<String> importedList = new ArrayList();

//		ANDIAMO A RICHIAMARE UN FILE
		File file = new File("./catalog.txt");

//		ANDIAMO A LEGGERE IL CONTENUTO DEL FILE DEFINITO PRECEDENTEMENTE SEMPRE IN FORMATO "UFT-8"
		String readString = FileUtils.readFileToString(file, "UTF-8");
		
//		LEGGE TUTTO IL CONTENUTO DEL FILE, E LO DIVIDIAMO OCUNQUE CI SIA "\N", SUCCESSIVAMENTE AGGIUNGIAMO IL TUTTO A CATALOG
		String[] catalog = readString.split("\n");

//		GENERIAMO UN FOR PER OGNI STRINGA DI CATALOG
		for (String element : catalog) {
//			AGGIUNGA QUELLA SINGOLA STRINGA ALLA LISTA DI STRINGHE GENERATA A INIZIO METODO
			importedList.add(element);
		}
//		DIAMO IN USCITA LA LISTA APPENA POPOLATA COME DETTATO NELL'INTERFACCIA
		return importedList;
	}

}
