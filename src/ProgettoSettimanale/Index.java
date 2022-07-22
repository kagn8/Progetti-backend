package ProgettoSettimanale;

import java.util.Scanner;

public class Index {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		System.out.println("seleziona l'elemento che vuoi visualizzare");
		
		
		//int scegli = scanner.nextInt();
		
		Media[] m = new Media[6];
		System.out.println(m.length);
		//m[0].titolo = "ciao";
		//System.out.println(m[0]);
		creazioneArray(m);
		
		scegliMedia(m);
		
		
		
		
		/*
		Audio canzone = new Audio("sing", 5, 10);
		canzone.volUp();
		canzone.volDown();
		canzone.play();
		
		Video film = new Video("Mission impossible", 5 , 5 , 5 );
		film.volUp();
		film.volDown();
		film.play();
		film.show();
		
		Immagine foto = new Immagine("Foto", 5);
		foto.show();
		*/
	}

	public static void creazioneArray(Media[] m) {
		for(int i =0; i<5; i++) {
			System.out.println("creazione oggetto multimediale n:"+ (i + 1)+"/5");
			System.out.println("Seleziona la tipologia");
			System.out.println("(1=audio)");
			System.out.println("(2=video)");
			System.out.println("(3=immagine)");
			int tipologia = Integer.parseInt(scanner.nextLine());
			if(tipologia == 1) {
				System.out.println("Inserisci il titolo del brano");
				String titolo = scanner.nextLine();
				System.out.println("inserisci il volume");
				int volume = Integer.parseInt(scanner.nextLine());
				System.out.println("inserisci la durata");
				int durata = Integer.parseInt(scanner.nextLine());
				Audio x = new Audio(titolo, volume, durata);
				m[i] = x;
			}else if(tipologia==2) {
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
			}else {
				System.out.println("Inserisci il titolo dell'immagine");
				String titolo = scanner.nextLine();
				System.out.println("inserisci la luminosità");
				int lum = Integer.parseInt(scanner.nextLine());
				Immagine x = new Immagine(titolo, lum);
				m[i]=x;
				
			}
			System.out.println("ciao" + m[i].titolo + "ciao" );
			
		}
		
	}
public static void scegliMedia(Media[] m) {
		int elementoMedia=0;
		do {
			System.out.println("cosa vuoi riprodurre? digita un numero da 1 a 5 oppure 0 per terminare la riproduzione");
			elementoMedia = Integer.parseInt(scanner.nextLine());
			int el=5;
			if(elementoMedia == 1){el = 0;};
			if(elementoMedia == 2){el = 1;};
			if(elementoMedia == 3){el = 2;};
			if(elementoMedia == 4){el = 3;};
			if(elementoMedia == 5){el = 4;};
			if(elementoMedia == 0){System.out.println("riproduzione terminata");};
			if(m[el] instanceof Immagine && el > -1) {m[el].show();}
			
			else if(m[el] instanceof Audio || m[el] instanceof Video) {m[el].play();}
		}while(elementoMedia!=0);
	}
}
	
