package ProgettoSettimanale;

public class Immagine extends Media implements Visualizza{
	int lumix;
	
	public Immagine(String titolo, int l) {
		super(titolo);
		lumix =l;
	}

	
	@Override
	public void show() {
		String lux = "";
		for(int i=0; i<lumix; i++) {
			lux += "*";
		}
		
		System.out.println("Immagine:"+titolo+" "+lux);
		
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
