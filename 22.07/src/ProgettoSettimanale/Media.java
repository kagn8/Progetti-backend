package ProgettoSettimanale;
//CREAZIONE CLASSE PRINCIPALE ASTRATTA CON GLI ATTRIBUTI COMUNI A TUTTI GLI ELEMENTI
public abstract class Media {
	//DEFINIZIONE DI TITOLO
	protected String titolo;
	//DEFINIAMO UN COSTRUTTORE CHE ASSEGNA IL TITOLO
	public Media(String titolo) {
		//ASSEGNAZIONE DEL TITOLO
		this.titolo = titolo;
		
	}
	//qUI CI SONO I METODI PLAY E SHOW, DA RIDEFINIRE ALL'INTERNO DELLE CLASSI
	public void play(){};
	public void show(){};
}
