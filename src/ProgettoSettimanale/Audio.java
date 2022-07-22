package ProgettoSettimanale;
//DEFINIAMO UNA CLASSE "AUDIO", CHE ESTENDE LA CLASSE ASTRATTA MAIN ED IMPLEMENTA LE INTERFACCE RIPRODUCI, E VISUALIZZA, IN QUANTO ELEMENTO VISUALIZZABILE E RIPRODUCIBILE
public class Audio extends Media implements Riproduci {
	//DEFINIAMO I PARAMETRI CHE QUESTA CLASSE ANDRà AD UTILIZZARE
	private int volume;
	private int durata;
	
	//DEFINIAMO UN COSTRUTTORE, DOVE ANDIAMO AD ASSEGNARE TUTTI I PARAMETRI IN FASE DI ISTANZIAMENTO
	public Audio(String titolo, int v, int d) {
		super(titolo);
		volume=v;
		durata=d;
	}

	@Override
	//DEFINIAMO IL METODO DICHIARATO NELL'INTERFACCIA
	public void play() {
		//LA FUNZIONE PLAY è MOLTO SIMILE A QUELLA DEI VIDEO
		System.out.println("Buon ascolto!");
		String escl = "";
		for(int i=0; i<volume; i++) {
			escl += "!";
		}
		for(int i=0; i<durata; i++) {
			System.out.println("Canzone:"+titolo+" "+escl+ " riprodotti:"+(i+1)+"secondi, restanti altri:" + (durata-(i+1))+"secondi");
			
			}
		System.out.println("La canzone:"+ titolo + " è terminata");
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
}
