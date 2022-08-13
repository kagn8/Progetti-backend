package it.epicode;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.entities.Atm;
import it.epicode.entities.AuthorizedDealer;
import it.epicode.entities.Bus;
import it.epicode.entities.Card;
import it.epicode.entities.Dealer;
import it.epicode.entities.Path;
import it.epicode.entities.SeasonTicket;
import it.epicode.entities.Ticket;
import it.epicode.entities.Tram;
import it.epicode.entities.Transport;
import it.epicode.entities.Travel;
import it.epicode.entities.TravelDocument;
import it.epicode.entities.TypeSeasonTicket;
import it.epicode.entities.User;
import it.epicode.services.Service;

//	Creazione del Program in cui lanciare i metodi per:
//	popolare il database;
//	effettuare le ricerche tramite le @NamedQuery
public class Program {

	public static final Logger log = LoggerFactory.getLogger(Program.class);
	public static Transport bus1 = new Bus(10);
	public static Transport tram1 = new Tram(20);

	public static void testAddTransport(Service s) {
		log.info("lancio metodo add transport");

		s.addTransport(bus1);
		s.addTransport(tram1);

		log.info("metodi add eseguiti correttamente");

	}

	public static void testEditTransport(Service serv) {
		log.info("lancio metodo edit transport");

		serv.editTransportStatus(tram1);

		log.info("metodi edit eseguiti correttamente");

	}

	public static User francesco = new User("Francesco");
	public static User riccardo = new User("Riccardo");
	public static User ignazio = new User("Ignazio");

	public static void testAddUser(Service serv) {
		log.info("lancio metodo AddUser");

		serv.addUser(francesco);
		serv.addUser(riccardo);
		serv.addUser(ignazio);

		log.info("metodi addUser eseguiti correttamente");

	}

	public static Card card1 = new Card(francesco);
	public static Card card2 = new Card(riccardo);
	public static Card card3 = new Card(ignazio);

	public static void testAddCard(Service serv) {
		log.info("lancio metodo AddCard");

		serv.addCard(card1);
		serv.addCard(card2);
		serv.addCard(card3);

		log.info("metodi addCard eseguiti correttamente");

	}

	public static Dealer auhorizedDealer1 = new AuthorizedDealer("via gassman, 15", "Milano", "Dealer1");
	public static Dealer atm = new Atm(true);

	public static void testAddDealer(Service serv) {
		log.info("lancio metodo AddDealer");

		serv.addDealer(auhorizedDealer1);
		serv.addDealer(atm);

		log.info("metodi addDealer eseguiti correttamente");

	}

	public static SeasonTicket seasonTicket1 = new SeasonTicket(auhorizedDealer1, TypeSeasonTicket.MONTHLY, card1);
	public static SeasonTicket seasonTicket2 = new SeasonTicket(atm, TypeSeasonTicket.WEEKLY, card2);
	public static SeasonTicket seasonTicket3 = new SeasonTicket(atm, TypeSeasonTicket.MONTHLY, card3);

	public static Ticket tk1 = new Ticket(atm);
	public static Ticket tk2 = new Ticket(auhorizedDealer1);
	public static Ticket tk3 = new Ticket(atm);
	public static Ticket tk4 = new Ticket(auhorizedDealer1);
	public static Ticket tk5 = new Ticket(atm);

	public static void testAddTravelDocument(Service serv) {
		log.info("lancio metodo AddTravelDocument");

		serv.addTravelDocument(seasonTicket1);
		serv.addTravelDocument(seasonTicket2);
		serv.addTravelDocument(seasonTicket3);
		serv.addTravelDocument(tk1);
		serv.addTravelDocument(tk2);
		serv.addTravelDocument(tk3);
		serv.addTravelDocument(tk4);
		serv.addTravelDocument(tk5);

		log.info("metodi addTravelDocument eseguiti correttamente");

	}

	public static Path path = new Path("Milano", "Nuova Dehli");
	public static Path path2 = new Path("Napoli", "Agrigento");

	public static void testAddPath(Service serv) {
		log.info("lancio metodo AddPath");

		serv.addPath(path, bus1);
		serv.addPath(path2, bus1);

		log.info("metodi addPath eseguiti correttamente");

	}

	public static Travel travel1 = new Travel(path, bus1, 10);
	public static Travel travel2 = new Travel(path2, tram1, 20);

	public static void testAddTravel(Service serv) {
		log.info("lancio metodo AddPath");

		serv.addTravel(travel1);
		serv.addTravel(travel2);

		log.info("metodi addPath eseguiti correttamente");

	}

	public static void testConvalidTravelDocument(Service serv) {
		log.info("lancio metodo che controlla i biglietti");

		serv.convalidateTicket(tk1, bus1);
		serv.convalidateTicket(tk2, bus1);
		serv.convalidateTicket(tk3, bus1);
		serv.convalidateTicket(tk4, bus1);

		serv.checkSeasonTicket(seasonTicket1);

		log.info("metodi di convalida eseguiti correttamente");

	}

	public static void testSearchTicketByDay(Service serv) {
		log.info("Ricerca biglietti convalidati per giorno:");
		List<TravelDocument> searchTicketByDay = serv.travelDocumentDao
				.searchTicketValidationDateForDay(LocalDate.now());

		for (TravelDocument t : searchTicketByDay) {
			log.info("Trovato: " + t);
		}
	}

	public static void testSearchTicketByPeriod(Service serv) {
		log.info("Ricerca biglietti convalidati per periodo:");
		List<TravelDocument> searchTicketByPeriod = serv.travelDocumentDao
				.searchTicketValidationDateForPeriod(LocalDate.of(2022, 8, 7), LocalDate.of(2022, 8, 11));

		for (TravelDocument t : searchTicketByPeriod) {
			log.info("Trovato: " + t);
		}
	}

	public static void testSearchTravelDocumentFromDealer(Service serv) {
		log.info("Ricerca biglietti venduti per periodo da un dealer:");
		List<TravelDocument> search3 = serv.travelDocumentDao.searchTravelDocumentFromDealer(atm,
				LocalDate.of(2022, 8, 7), LocalDate.of(2022, 8, 12));

		for (TravelDocument t : search3) {
			log.info("Trovato: " + t);
		}
	}

	public static void main(String[] args) {

		Service serv = new Service();

		testAddTransport(serv);
		testEditTransport(serv);
		testAddUser(serv);
		testAddCard(serv);
		testAddDealer(serv);
		testAddTravelDocument(serv);
		testAddPath(serv);
		testAddTravel(serv);
		testConvalidTravelDocument(serv);
		testSearchTicketByDay(serv);
		testSearchTicketByPeriod(serv);
		testSearchTravelDocumentFromDealer(serv);

	}

}