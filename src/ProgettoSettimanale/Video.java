package ProgettoSettimanale;
//DEFINIAMO UNA CLASSE "VIDEO", CHE ESTENDE LA CLASSE ASTRATTA MAIN ED IMPLEMENTA LE INTERFACCE RIPRODUCI, E VISUALIZZA, IN QUANTO ELEMENTO VISUALIZZABILE E RIPRODUCIBILE
public class Video extends Media implements Riproduci, Visualizza {
	//DEFINIAMO I PARAMETRI CHE QUESTA CLASSE ANDRà AD UTILIZZARE
	private int volume;
	private int lumix;
	private int durata;
	
	//DEFINIAMO UN COSTRUTTORE, DOVE ANDIAMO AD ASSEGNARE TUTTI I PARAMETRI IN FASE DI ISTANZIAMENTO
	public Video(String titolo,int l, int d, int v) {
		super(titolo);
		lumix = l;
		durata=d;
		volume=v;
	}

	@Override
	//DEFINIAMO IL METODO DICHIARATO NELL'INTERFACCIA
	public void play() {
		//DEFINIAMO UNA VARIABILE STRINGA SETTATA INIZIALMENTE COME STRINGA VUOTA
		String lux = "";
		//ATTRAVERSO QUESTO CICLO ANDIAMO A COSTRUIRE LA VARIABILE STRINGA CON TANTI ASTERISCHI TANTO QUANTO è ALTO IL VALORE DELLA LUMINOSITà (LUMIX)
		for(int i=0; i<lumix; i++) {
			lux += "*";
		}
		//ANALOGAMENTE FACCIAMO UN CICLO CON LO STESSO FUNZIONAMENTO PER QUANTO RIGUARDA IL VOLUME
		String escl = "";
		for(int i=0; i<volume; i++) {
			escl += "!";
		}
		for(int i=0; i<volume; i++) {
			escl += "!";
		}
		//UNA STRINGA IN CONSOLE CHE CI AVVISA CHE IL METODO è PARTITO
		System.out.println("Buona visione!");
		
		//QUI ABBIAMO LA "RIPRODUZIONE" DEL CONTENUTO, OVVERO CHE PER OGNI CICLO DEFINITO DALLA DURATA, USCIRà IN CONSOLE UN MESSAGGIO (ES. video:Mission impossible !!!!!!!!!! ***** riprodotti:1secondi, restanti altri:4secondi)
		for(int i=0; i<durata; i++) {
			System.out.println("video:"+titolo+" "+escl+" "+lux+ " riprodotti:"+(i+1)+"secondi, restanti altri:" + (durata-(i+1))+"secondi");
			
			}
		//UNA STRINGA IN CONSOLE CI AVVERTE DELLA FINE DEL METODO
		System.out.println("Il video:"+ titolo + " è terminato");
		
	}
	//UNA STRINGA PER VISUALIZZARE I DETTAGLI DEL VIDEO
	@Override
	public void show() {
		System.out.println("dettagli video: Titolo: "+titolo+" durata:"+durata+"s");
	}

	//DEFINIAMO I METODI DICHIARATI NELL'INTERFACCIA, QUESTI METODI COME SI PUò VEDERE SONO ABBASTANZA DESCRITTIVI E SEMPLICI
	@Override
	public void volUp() {
		volume++;
	}

	@Override
	public void volDown() {
		volume--;
	}
	
	@Override
	public void AumentaL() {
		lumix++;
	}

	@Override
	public void DiminuisciL() {
		lumix--;
	}
}