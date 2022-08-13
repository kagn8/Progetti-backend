package it.epicode.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import it.epicode.Program;
import it.epicode.Dao.CardDao;
import it.epicode.Dao.DealerDao;
import it.epicode.Dao.PathDao;
import it.epicode.Dao.TransportDao;
import it.epicode.Dao.TravelDAO;
import it.epicode.Dao.TravelDocumentDao;
import it.epicode.Dao.UserDao;
import it.epicode.entities.Card;
import it.epicode.entities.Dealer;
import it.epicode.entities.Path;
import it.epicode.entities.SeasonTicket;
import it.epicode.entities.Ticket;
import it.epicode.entities.Transport;
import it.epicode.entities.Travel;
import it.epicode.entities.TravelDocument;
import it.epicode.entities.User;
import it.epicode.utils.JpaUtil;

public class Service {

	public final Logger log = LoggerFactory.getLogger(Program.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

//	Gestione Trasporti
	TransportDao transportDao = new TransportDao();

//	Metodo per la creazione di un Transport
	public void addTransport(Transport x) {
		transportDao.addTransport(x);
	}

// Metodo per settare lo stato del Transport

	public void editTransportStatus(Transport x) {
		transportDao.editTrasportStatus(x);
	}

//	Gestione User
	UserDao userDao = new UserDao();
	CardDao cardDao = new CardDao();

//	Metodo per la creazione di un User
	public void addUser(User x) {
		userDao.addUser(x);
	}

//	Metodo per la creazione di una Card
	public void addCard(Card x) {
		cardDao.addCard(x);
	}

//	Gestione Biglietti
	public TravelDocumentDao travelDocumentDao = new TravelDocumentDao();
	DealerDao dealerDao = new DealerDao();

// Metodo per la creazione di un Dealer	
	public void addDealer(Dealer x) {
		dealerDao.addDealer(x);
	}

// Metodo per la creazione di un Ticket	
	public void addTravelDocument(TravelDocument x) {
		travelDocumentDao.addDocument(x);
	}

// 	Gestione path
	PathDao pathDao = new PathDao();

// Metodo per la creazione di una Path	
	public void addPath(Path x, Transport y) {
		pathDao.addPath(x);
		pathDao.addTransportToPath(x.getId(), y);
	}

//  Gestione Travel
	TravelDAO travelDao = new TravelDAO();

// Metodo per la creazione di un Travel
	public void addTravel(Travel x) {
		travelDao.addTravel(x);
	}

// Metodo per la convalida un Travel Document
	public void convalidateTicket(TravelDocument t, Transport tr) {

		EntityManager em = emf.createEntityManager();

		Transport x = em.find(Transport.class, tr.getId());
		TravelDocument y = em.find(TravelDocument.class, t.getId());

		try {
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			if (y instanceof Ticket) {
				log.info("" + ((Ticket) y).isValidate());
				if (((Ticket) y).isValidate() == false) {
					((Ticket) y).setValidate(true);
					((Ticket) y).setConvalidateBy(x);
					log.info("Biglietto valido");
					log.info("" + ((Ticket) y).isValidate());

				} else {
					log.error("Il biglietto è già stato convalidato");
				}
			}
			trans.commit();

		} catch (Exception e) {
			log.error("Errore", e);

		} finally {
			em.close();
			if (y instanceof Ticket) {
				travelDocumentDao.covalidationTicket((Ticket) y, x);
			}
		}

	}

	public void checkSeasonTicket(SeasonTicket st) {
		travelDocumentDao.checkSeasonTicket(st);
	}

}
