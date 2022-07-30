package ProgettoSettimanale;

import java.util.Scanner;

public class Index {
	//INIZIALIZZIAMO L'OGETTO SCANNER CHE UTILIZZEREMO PIù AVANTI
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
//ANDIAMO A DEFINIRE UN ARRAY DI MEDIA CHE DEVE CONTENERE I NOSTRI OGGETTI CREATI
		Media[] m = new Media[5];
		// ANDIAMO A LANCIARE IL METODO PER POPOLARE L'ARRAY
		creazioneArray(m);
		// LANCIAMO IL METODO CHE CI PERMETTE DI SELEZIONARE L'ELEMENTO DELL'ARRAY DA
		// RIPRODURRE
		scegliMedia(m);

	}

	// DEFINIAMO IL METODO PER POPOLARE L'ARRAY CON DEGLI OGGETTI CHE ANDIAMO A
	// CREARE ADESSO
	public static void creazioneArray(Media[] m) {
		// CREIAMO UN CICLO DOVE PER OGNI ELEMENTO DELL'ARRAY FACCIAMO UN GIRO (IN
		// QUESTO CASO 5)
		for (int i = 0; i < (m.length - 1); i++) {
			// DIAMO LE ISTRUZIONI ALL'UTILIZZATORE
			System.out.println("creazione oggetto multimediale n:" + (i + 1) + "/5");
			System.out.println("Seleziona la tipologia");
			System.out.println("(1=audio)");
			System.out.println("(2=video)");
			System.out.println("(3=immagine)");
			// ANDIAMO A FAR INSERIRE ALL'UTILIZZATORE LA TIPOLOGIA DELL'OGGETTO CHE VUOLE
			// GENERARE
			int tipologia = Integer.parseInt(scanner.nextLine());
			// CREIAMO DELLE CONDIZIONI, LE QUALI IN BASE ALLA TIPOLOGIA SELEZIONATA
			// GENERANO OGGETTI DIFFERENTI
			if (tipologia == 1) {
				// STAMPIAMO L'ISTRUZIONE ALL'UTILIZZATORE
				System.out.println("Inserisci il titolo del brano");
				// GLI DIAMO L'OPPORTUNITà DI INSERIRE L'INPUT
				String titolo = scanner.nextLine();
				// COSì PER OGNI PARAMETRO, SALVE QUELLI DI TIPO INT I QUALI DEVONO ESSERE
				// CONVERTITI
				System.out.println("inserisci il volume");
				int volume = Integer.parseInt(scanner.nextLine());
				System.out.println("inserisci la durata");
				int durata = Integer.parseInt(scanner.nextLine());
				// QUI C'è L'ISTANZA VERA E PROPRIA DELL'OGGETTO
				Audio x = new Audio(titolo, volume, durata);
				// ANDIAMO A SOSTITUIRE ALL'INTERNO DELL'ARRAY PRESO IN INGRESSO ALLA POSIZIONE
				// "I" L'OGETTO APPENA GENERATO
				m[i] = x;
			} else if (tipologia == 2) {
				// LE TIPOLOGIE SONO COSTRUITE TUTTE E 3 ALLO STESSO MODO SOSTANZIALMENTE
				System.out.println("Inserisci il titolo del video");
				String titolo = scanner.nextLine();
				System.out.println("inserisci la luminosità");
				int lum = Integer.parseInt(scanner.nextLine());
				System.out.println("inserisci la durata");
				int durata = Integer.parseInt(scanner.nextLine());
				System.out.println("inserisci il Volume");
				int volume = Integer.parseInt(scanner.nextLine());
				Video x = new Video(titolo, lum, durata, volume);
				m[i] = x;
			} else {
				System.out.println("Inserisci il titolo dell'immagine");
				String titolo = scanner.nextLine();
				System.out.println("inserisci la luminosità");
				int lum = Integer.parseInt(scanner.nextLine());
				Immagine x = new Immagine(titolo, lum);
				m[i] = x;

			}

		}

	}

	// DEFINIAMO ADESSO IL METODO SCEGLI MEDIA, OVVERO IL METODO CHE TRAMITE UN
	// CICLO DO-WHILE, DA LA POSSIBILITà ALL'UTILIZZATORE DI "RIPRODURRE" UN
	// DETERMINATO MEDIA
	public static void scegliMedia(Media[] m) {
		// DEFINIAMO L'ELEMENTO CHE L'UTILIZZATORE STAMPA IN CONSOLE
		int elementoMedia = 0;
		// COSTRUIAMO IL CICLO DO-WHILE CHE APPUNTO DA CICLICAMENTE LA POSSIBILITà
		// ALL'UTILIZZATORE DI INSERIRE L'IMPUT PER DICHIARARE L'ELEMENTO DA
		// VISUALIZZARE
		do {
			System.out
					.println("Cosa vuoi riprodurre? digita un numero da 1 a 5 oppure 0 per terminare la riproduzione");
			elementoMedia = Integer.parseInt(scanner.nextLine());
			// CREIAMO UNA SERIE DI IF PER MODIFICARE L'INPUT CHE L'UTENTE GENERA
			// ALL'INGRESSO
			int el = elementoMedia -1;

	
			

			if (elementoMedia == 0) {
				//CREIAMO LA CONDIZIONE SECONDO LA QUALE PREMENDO 0 IN TERMINALE LA RIPRODUZIONE VIENE TERMINATA
				System.out.println("riproduzione terminata");
			}

			else if (m[el] instanceof Immagine && el > -1) {
				//CREIAMO LA CONDIZIONE SECONDO LA QUALE CONTROLLIAMO CHE TIPO DI INTERFACCIA ABBIA L'ELEMENTO SELEZIONATO IN QUESTO CASO DEFINIAMO CHE SE è UN IMMAGINE, APPLICHIAMO IL METODO SHOW()
				m[el].show();
			}

			else if (m[el] instanceof Audio || m[el] instanceof Video) {
				//CREIAMO LA CONDIZIONE SECONDO LA QUALE CONTROLLIAMO CHE TIPO DI INTERFACCIA ABBIA L'ELEMENTO SELEZIONATO IN QUESTO CASO DEFINIAMO CHE SE è UN VIDEO O UN AUDIO, APPLICHIAMO IL METODO PLAY()
				m[el].play();
			}
		} while (elementoMedia != 0);
		//TERMINIAMO IL CICLO
	}
}
