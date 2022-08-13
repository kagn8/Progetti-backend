package it.epicode.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.Program;
import it.epicode.Dao.interfaces.DealerDaoInterface;
import it.epicode.entities.Atm;
import it.epicode.entities.Dealer;
import it.epicode.utils.JpaUtil;

//	Creazione del DAO per i Dealer
public class DealerDao implements DealerDaoInterface {

	private static final Logger log = LoggerFactory.getLogger(Program.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

//	Metodo per l'aggiunta di un nuovo Dealer
	public void addDealer(Dealer t) {
		EntityManager em = emf.createEntityManager();

		try {
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(t);
			trans.commit();
		} catch (Exception e) {
			log.error("Errore nell'aggiunta del dealer", e);
		} finally {
			em.close();

		}
	}

//	Metodo per la rimozione di un Dealer
	public void removeDealer(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			Dealer x = em.find(Dealer.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.remove(x);
			trans.commit();

		} catch (Exception e) {
			log.error("Errore nella rimozione del dealer", e);

		} finally {
			em.close();

		}
	}

//	Metodo per la modifica dello stato di un Atm
	public void editAtmStatus(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			Dealer x = em.find(Dealer.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			if (x instanceof Atm) {
				((Atm) x).setActive(!((Atm) x).isActive());
			} else {
				log.error("Errore");
			}
			trans.commit();
		} catch (Exception e) {
			log.error("Errore nella modifica del dealer", e);

		} finally {
			em.close();

		}
	}
}