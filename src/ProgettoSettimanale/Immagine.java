package ProgettoSettimanale;
//DEFINIAMO UNA CLASSE IMMAGINE PER GENERARE FILE "IMMAGINE"
public class Immagine extends Media implements Visualizza{
	//DEFINIAMO I PARAMETRI DELLA DATA CLASSE
	int lumix;
	//GENERIAMO UN COSTRUTTORE PER DEFINIRE I PARAMETRI DELL'OGETTO UNA VOLTA INIZIALIZZATO
	public Immagine(String titolo, int l) {
		super(titolo);
		lumix =l;
	}

	
	@Override
	//DEFINIAMO UN METODO PER "MOSTRARE" L'IMMAGINE IN CONSOLE
	public void show() {
		//GENERIAMO UN CICLO PER AGGIUNGERE GLI ASTERISCHI IN BASE AL VALORE DELLA LUMINOSITà
		String lux = "";
		for(int i=0; i<lumix; i++) {
			lux += "*";
		}
		
		System.out.println("Immagine:"+titolo+" "+lux);
		
	}

	@Override
	//DEFINIAMO I METODI BASE DETTATI DELL'INTERFACCIA, COMUNQUE ANCHESSI, ABBASTANZA DESCRITTIVI 
	public void AumentaL() {
		lumix++;
		
	}

	@Override
	public void DiminuisciL() {
		lumix--;
		
	}

}
