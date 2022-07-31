package it.epicode.catalogo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// GENERIAMO UNA CLASSE CHE IMPLEMENTA L'INTERFACCIA ImportExportData
public class ImportExportDataClass implements ImportExportData {

	private static final Logger Log = LoggerFactory.getLogger(ArchiveMain.class);

//	INIZIALIZZIAMO UNA LISTA
	public Map<String, Catalog> mainCatalog;

//	GENERIAMO UN COSTRUTTORE CHE PERMETTE A CHI LO LANCIA DI POPOLARE LA LISTA SOPRACITATA
	public ImportExportDataClass(Map<String, Catalog> mainCatalog) {

		this.mainCatalog = mainCatalog;
	}

//	ANDIAMO A DEFINIRE IL METODO WRITE DICHIARATO NELL'INTERFACCIA
	@Override
	public void writeToExternalFile() throws IOException {
		try {
//		INIZIALIZZIAMO UNA STRINGA VUOTA
			String catalogToText = "";

//		GENERIAMO UN FOR CHE ANDRA AD AGIRE SUL MAIN CATALOG E PER OGNI VALORE AL SUO INTERNO
			for (Catalog cat : mainCatalog.values()) {
//			GENERA UNA STRINGA E LA AGGIUNGE ALLA VARIABILE STRINGA VUOTA GENERATA IN QUESTO METODO SEGUITA DA "\N" CHE MANDA A CAPO TRA UNA RIGA E L'ALTRA
				catalogToText += (cat.toString() + "\n");

			}
//		CREIAMO IL FILE DI TESTO CATALOG.TXT NELLA CARTELLA DEL NOSTRO PROGETTO
			File catalogFile = new File("./catalog.csv");
			Log.info("Scrittura eseguita correttamente");
//		RACCOGLIAMO IL CONTENUTO DELLA STRINGA CREATA PRECEDENTEMENTE E LA SCRIVIAMO NEL FILE APPENA GENERATO, SECONDO IL SET DI CARATTERI "ISO_8859_1"
			FileUtils.writeStringToFile(catalogFile, catalogToText, StandardCharsets.ISO_8859_1);
		} catch (IOException e) {
			Log.error("Errore durante il caricamento" + e);
		}
	}

//	ANDIAMO A DEFINIRE IL METODO READ DICHIARATO NELL'INTERFACCIA
	@Override
	public Map<String, Catalog> readToExternalFile() throws IOException {
//		INSERIAMO TUTTO INUN TRY COSì DA POTER PREVENIRE ERRORI
		try {
//		ANDIAMO A RICHIAMARE UN FILE
			File file = new File("./catalog.csv");
//		ANDIAMO A LEGGERE IL CONTENUTO DEL FILE DEFINITO PRECEDENTEMENTE SEMPRE IN FORMATO "ISO_8859_1"
			List<String> lines = FileUtils.readLines(file, StandardCharsets.ISO_8859_1);

			mainCatalog = lines.stream().map(line -> line.split(";")).map(el -> {
//				PER OGNI STRINGA SCRITTA PRECEDENTEMENTE DEFINIAMO TRAMITE LA LUNGHEZZA DELL'OGGETTO SE CREARE UN LIBRO O UNA RIVISTA E LO AGGIUNGIAMO ALLA NOSTRA LISTA
				if (el.length == 6) {
					return new Book(el[0], el[1], el[2], Integer.parseInt(el[3]), el[4], el[5]);
				} else {
					return new Magazine(el[0], el[1], el[2], Integer.parseInt(el[3]), Periodicity.valueOf(el[4]));
				}
//		CON GLI ELEMENTI IN USCITA DI TIPO CATALOG CREIAMO UNA NUOVA MAP LIST
			}).collect(Collectors.toMap(c -> c.getISBNcode(), c -> c));

			Log.info("Lettura eseguita correttamente");
//			RITORNIAMO LA NUOVA LISTA
			return mainCatalog;
//		GENERIAMO UN CATCH PER INTERCETTARE EROORI
		} catch (IOException e) {
			Log.error("errore durante la lettura dei file" + e);
		}
//		DIAMO IN USCITA LA LISTA APPENA POPOLATA COME DETTATO NELL'INTERFACCIA
		return mainCatalog;

	}

}
