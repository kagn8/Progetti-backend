package it.epicode.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.Program;
import it.epicode.Dao.interfaces.TravelDaoInterface;
import it.epicode.entities.Status;
import it.epicode.entities.Travel;
import it.epicode.utils.JpaUtil;

//	Creazione del DAO per i Travel
public class TravelDAO implements TravelDaoInterface {

	private static final Logger log = LoggerFactory.getLogger(Program.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

//	Metodo per l'aggiunta di un Travel	
	public void addTravel(Travel t) {
		EntityManager em = emf.createEntityManager();

		if (t.getTransport().getStatus() == Status.ONSERVICE) {
			try {

				EntityTransaction trans = em.getTransaction();
				trans.begin();

				em.persist(t);

				trans.commit();
			} catch (Exception e) {
				log.error("Errore nell'aggiunta di un travel al database", e);
			} finally {
				em.close();

			}
		} else {
			log.error("Impossibile viaggiare, il mezzo è in manutenzione");
		}
	}

//	Metodo per la rimozione di un Travel	
	public void removeTravel(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			Travel x = em.find(Travel.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.remove(x);
			trans.commit();

		} catch (Exception e) {
			log.error("Errore nella rimozione di un travel dal database", e);

		} finally {
			em.close();

		}
	}

//	Metodo per la ricerca di una Path tramite l'idTransport	
	public int searchPathFromBus(int idTransport, int idPath) {
		EntityManager em = emf.createEntityManager();

		try {
			var query = em.createNamedQuery("searchPathFromBus", Travel.class);
			query.setParameter("transId", idTransport);
			query.setParameter("pathId", idPath);
			List<Travel> list = query.getResultList();
			return list.size();

		} catch (Exception e) {
			log.error("Errore nella ricerca delle path di un transport", e);

			return 0;
		} finally {
			em.close();

		}
	}

//	Metodo per il calcolo del tempo effettivo di viaggio	
	public int calcolateEffectiveTime(int idPath) {
		EntityManager em = emf.createEntityManager();

		try {
			var query = em.createNamedQuery("searchForPath", Travel.class);
			query.setParameter("pathId", idPath);
			List<Travel> list = query.getResultList();

			int i = 0;

			for (Travel t : list) {
				i += t.getEffectiveTimeTravel();
			}

			int y = i / list.size();

			return y;

		} catch (Exception e) {
			log.error("Errore del metodo calcolateEffectiveTime", e);

			return 0;
		} finally {
			em.close();

		}
	}

}
