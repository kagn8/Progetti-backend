package it.epicode.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.Program;
import it.epicode.Dao.interfaces.UserDaoInterface;
import it.epicode.entities.User;
import it.epicode.utils.JpaUtil;

//	Creazione del Dao per l'User
public class UserDao implements UserDaoInterface {
	private static final Logger log = LoggerFactory.getLogger(Program.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

//	Metodo per la creazione di un User	
	public void addUser(User u) {
		EntityManager em = emf.createEntityManager();
		try {

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(u);
			trans.commit();
		} catch (Exception e) {
			log.error("Errore nell'aggiunta di uno user");
		} finally {
			em.close();

		}
	}

//	Metodo per la rimozione di un User	
	public void removeUser(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			User x = em.find(User.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.remove(x);
			trans.commit();

		} catch (Exception e) {
			log.error("Errore nella rimozione di uno user", e);

		} finally {
			em.close();

		}
	}

//	Metodo per la modifica del nome di un User
	public void editUserSetName(int id, String n) {
		EntityManager em = emf.createEntityManager();
		try {
			User x = em.find(User.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			x.setName(n);
			trans.commit();

		} catch (Exception e) {
			log.error("Errore nel settare un nuovo nome all'utente", e);

		} finally {
			em.close();

		}

	}
}