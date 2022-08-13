package it.epicode.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.Program;
import it.epicode.Dao.interfaces.TransportDaoInterface;
import it.epicode.entities.Status;
import it.epicode.entities.Transport;
import it.epicode.utils.JpaUtil;

//	Creazione del Dao per i Transport
public class TransportDao implements TransportDaoInterface {

	private static final Logger log = LoggerFactory.getLogger(Program.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

//	Metodo per la creazione di un Transport	
	public void addTransport(Transport t) {
		EntityManager em = emf.createEntityManager();

		try {

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(t);
			trans.commit();
		} catch (Exception e) {
			log.error("Errore nell'aggiunta del transport");
		} finally {
			em.close();

		}
	}

//	Metodo per la rimozione di un Transport	
	public void removeTransport(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			Transport x = em.find(Transport.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.remove(x);
			trans.commit();

		} catch (Exception e) {
			log.error("Errore nella rimozione del trasport", e);

		} finally {
			em.close();

		}
	}

//	Metodo per la modifica dello stato di un Transport (in manutenzione o in servizio)	
	public void editTrasportStatus(Transport t) {
		EntityManager em = emf.createEntityManager();

		try {
			Transport x = em.find(Transport.class, t.getId());

			EntityTransaction trans = em.getTransaction();
			trans.begin();

			if (x.getStatus() == Status.MAINTENANCE) {
				x.setStatus(Status.ONSERVICE);
			} else {
				x.setStatus(Status.MAINTENANCE);
			}

			trans.commit();

		} catch (Exception e) {
			log.error("Errore dell'edit dello status del trasport", e);

		} finally {

			em.close();

			if (t.getStatus() == Status.MAINTENANCE) {
				t.setStatus(Status.ONSERVICE);
			} else {
				t.setStatus(Status.MAINTENANCE);
			}

		}

	}

//	Metodo per la ricerca di un trasporto tramite il paramentro ID	
	public Transport searchTransportById(int idTransport) {
		EntityManager em = emf.createEntityManager();

		try {
			var query = em.createNamedQuery("searchTransportById", Transport.class);
			query.setParameter("id", idTransport);

			Transport tr = query.getSingleResult();
			return tr;

		} catch (Exception e) {
			log.error("Errore della ricerca del trasport tramite ID", e);

			return null;
		} finally {
			em.close();

		}
	}

}