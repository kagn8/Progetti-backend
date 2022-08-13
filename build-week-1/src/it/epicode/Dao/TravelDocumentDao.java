package it.epicode.Dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.Program;
import it.epicode.Dao.interfaces.TravelDocumentDaoInterface;
import it.epicode.entities.Dealer;
import it.epicode.entities.SeasonTicket;
import it.epicode.entities.Ticket;
import it.epicode.entities.Transport;
import it.epicode.entities.TravelDocument;
import it.epicode.utils.JpaUtil;

//	Creazione del DAO per i TravelDocument
public class TravelDocumentDao implements TravelDocumentDaoInterface {
	private static final Logger log = LoggerFactory.getLogger(Program.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

//	Metodo per la creazione di un TravelDocument	
	public void addDocument(TravelDocument t) {
		EntityManager em = emf.createEntityManager();

		try {

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(t);
			trans.commit();
		} catch (Exception e) {
			log.error("Errore nell'aggiunta di un travelDocument al database");
		} finally {
			em.close();

		}
	}

//	Metodo per la rimozione di un TravelDocument	
	public void removeDocument(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			TravelDocument x = em.find(TravelDocument.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.remove(x);
			trans.commit();

		} catch (Exception e) {
			log.error("Errore nella rimozione di un travelDocument dal database", e);

		} finally {
			em.close();

		}
	}

//	Metodo per la ricerca di un TravelDocument tramite un Dealer	
	public List<TravelDocument> searchTravelDocumentFromDealer(Dealer d, LocalDate startDate, LocalDate endDate) {
		EntityManager em = emf.createEntityManager();

		try {
			var query = em.createNamedQuery("searchTravelDocumentFromDealer", TravelDocument.class);
			query.setParameter("dealer", d);
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			List<TravelDocument> list = query.getResultList();
			return list;
		} catch (Exception e) {
			log.error("Errore nella ricerca travelDocument rilasciati da un dealer", e);
			return new ArrayList<>();
		} finally {
			em.close();

		}
	}

//	Metodo per la ricerca dei Ticket vidimati su un Transport	
	public List<TravelDocument> searchTicketValidateByTransport(Transport tr) {
		EntityManager em = emf.createEntityManager();

		try {
			var query = em.createNamedQuery("searchTicketValidateByTransport", TravelDocument.class);
			query.setParameter("transport", tr);
			List<TravelDocument> list = query.getResultList();
			return list;
		} catch (Exception e) {
			log.error("Errore nella ricerca dei biglietti rilasciati da un determinato transport", e);
			return new ArrayList<>();
		} finally {
			em.close();

		}
	}

//	Metodo per la ricerca dei Ticket vidimati per data	
	public List<TravelDocument> searchTicketValidationDateForDay(LocalDate date) {
		EntityManager em = emf.createEntityManager();

		try {
			var query = em.createNamedQuery("searchTicketValidationDateForDay", TravelDocument.class);
			query.setParameter("date", date);
			List<TravelDocument> list = query.getResultList();
			return list;
		} catch (Exception e) {
			log.error("Errore nella ricerca di ticket rilasciati in un datoi giorno", e);
			return new ArrayList<>();
		} finally {
			em.close();

		}
	}

//	Metodo per la ricerca dei ticket validati dato uno specifico periodo	
	public List<TravelDocument> searchTicketValidationDateForPeriod(LocalDate startDate, LocalDate endDate) {
		EntityManager em = emf.createEntityManager();

		try {
			var query = em.createNamedQuery("searchTicketValidationDateForPeriod", TravelDocument.class);
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			List<TravelDocument> list = query.getResultList();
			return list;
		} catch (Exception e) {
			log.error("Errore nella ricerca travelDocument rilasciati da un dealer in un determinato periodo di tempo",
					e);
			return new ArrayList<>();
		} finally {
			em.close();

		}
	}

//	Metodo per il rinnovo di un SeasonTicket
	public void renewSeasonTicket(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			TravelDocument x = em.find(TravelDocument.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			if (x instanceof SeasonTicket) {
				((SeasonTicket) x).setIssueDate(LocalDate.now());
				trans.commit();
			}
		} catch (Exception e) {
			log.error("Errore nel rinnovo dell'abbonamento", e);
		} finally {
			em.close();

		}

	}

//	Metodo per la convalida di un Ticket	
	public void covalidationTicket(Ticket t, Transport tr) {
		EntityManager em = emf.createEntityManager();

		try {
			Ticket x = em.find(Ticket.class, t.getId());

			EntityTransaction trans = em.getTransaction();
			trans.begin();

			x.setValidate(true);
			x.setConvalidateBy(tr);
			x.setConvalidationDate(LocalDate.now());

			trans.commit();

		} catch (Exception e) {
			log.error("Errore nella convalida del biglietto", e);
		} finally {
			em.close();

		}

	}
	
	public void checkSeasonTicket(SeasonTicket st) {
        EntityManager em = emf.createEntityManager();

        try {
            var query = em.createNamedQuery("checkSeasonTicket", TravelDocument.class);
            query.setParameter("id", st.getId());
            SeasonTicket t = (SeasonTicket) query.getSingleResult();

            if (t.getExpireDate().isAfter(LocalDate.now())) {
                log.info("L'abbonamento è valido");
            } else {
                log.error("L'abbonamento è scaduto!");
            }

        } catch (Exception e) {
            log.error("Errore nel controllo dell'abbonamento", e);

        } finally {
            em.close();

        }
    }
}
