package it.epicode.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.Program;
import it.epicode.Dao.interfaces.PathDaoInterface;
import it.epicode.entities.Path;
import it.epicode.entities.Transport;
import it.epicode.utils.JpaUtil;

//	Creazione del DAO per le Path
public class PathDao implements PathDaoInterface {

	private static final Logger log = LoggerFactory.getLogger(Program.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

//	Metodo per l'aggiunta di una path
	public void addPath(Path p) {
		EntityManager em = emf.createEntityManager();

		try {

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(p);
			trans.commit();
		} catch (Exception e) {
			log.error("Errore nell'aggiunta di path", e);
		} finally {
			em.close();

		}
	}

//	Metodo per la rimozione di una Path
	public void removePath(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			Path x = em.find(Path.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.remove(x);
			trans.commit();

		} catch (Exception e) {
			log.error("Errore nella rimozione della path", e);

		} finally {
			em.close();

		}
	}

//	Metodo per la creazione della partenza 
	public void editPathStart(int id, String start) {
		EntityManager em = emf.createEntityManager();

		try {
			Path x = em.find(Path.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();

			x.setStart(start);

			trans.commit();

		} catch (Exception e) {
			log.error("Errore nella modifica della partenza della path", e);

		} finally {
			em.close();

		}

	}

//	Metodo per la creazione del capolinea di una Path
	public void editPathEnd(int id, String end) {
		EntityManager em = emf.createEntityManager();

		try {
			Path x = em.find(Path.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();

			x.setRide(end);

			trans.commit();

		} catch (Exception e) {
			log.error("Errore nella modifica del capolinea della path", e);

		} finally {
			em.close();

		}

	}

//	Metodo per il calcolo del tempo medio di percorrenza di una Path
	public void editPathAverageTime(int id, int time) {
		EntityManager em = emf.createEntityManager();

		try {
			Path x = em.find(Path.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();

			x.setAverageTime(time);

			trans.commit();

		} catch (Exception e) {
			log.error("Errore nel determinare il tempo medio della path", e);

		} finally {
			em.close();

		}

	}

//	Metodo per l'assegnazione di un Transport ad una Path
	public void addTransportToPath(int id, Transport t) {
		EntityManager em = emf.createEntityManager();

		try {

			Path x = em.find(Path.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();

			x.setTransport(t);

			trans.commit();

		} catch (Exception e) {
			log.error("Errore dell'associazione path/trasport", e);

		} finally {
			em.close();

		}

	}

}