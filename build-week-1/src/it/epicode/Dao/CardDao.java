package it.epicode.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.Program;
import it.epicode.Dao.interfaces.CardDaoInterface;
import it.epicode.entities.Card;
import it.epicode.utils.JpaUtil;

//	Creazione DAO per le Card
public class CardDao implements CardDaoInterface {
	private static final Logger log = LoggerFactory.getLogger(Program.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

//	Metodo per la creazione di una card
	public void addCard(Card u) {
		EntityManager em = emf.createEntityManager();

		try {

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(u);
			trans.commit();
		} catch (Exception e) {
			log.error("Errore nell'aggiunta della carta", e);
		} finally {
			em.close();

		}
	}

//	Metodo per la rimozione di una card
	public void removeCard(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			Card x = em.find(Card.class, id);

			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.remove(x);
			trans.commit();

		} catch (Exception e) {
			log.error("Errore nella rimozione della carta", e);

		} finally {
			em.close();

		}
	}
}
