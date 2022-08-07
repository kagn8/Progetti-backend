package it.epicode.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.Program;
import it.epicode.entities.library.Catalog;
import it.epicode.service.Service;
import it.epicode.entities.library.Book;
import it.epicode.utils.JpaUtil;

public class CatalogDAO {
	private static final Logger log = LoggerFactory.getLogger(Program.class);

	Service serv = new Service();

	public void addToCatalog(Catalog elemento) {
		try {
			EntityTransaction transaction = serv.em.getTransaction();
			transaction.begin();
			serv.em.persist(elemento);
			transaction.commit();
		} catch (Exception e) {
			log.error("Error" + e);
		} finally {
			serv.em.close();
		}
	}

	public void removeToCatalogByIsbn(String isbn) {
		try {
			var query = serv.em.createNamedQuery(Catalog.QUERY_SELECT_SEARCH_ISBN, Catalog.class);
			query.setParameter("isbn", isbn);
			Catalog el = query.getSingleResult();
			Catalog i = serv.em.find(Catalog.class, el.getId());
			EntityTransaction transaction = serv.em.getTransaction();
			transaction.begin();
			serv.em.remove(i);
			transaction.commit();

		} catch (Exception e) {
			log.error("Error" + e);
		} finally {
			serv.em.close();
		}

	}

	public Catalog searchByIsbn(String Isbn) {
		try {
			var query = serv.em.createNamedQuery(Catalog.QUERY_SELECT_SEARCH_ISBN, Catalog.class);
			query.setParameter("isbn", Isbn);
			Catalog el = query.getSingleResult();
			return el;
		} catch (Exception e) {
			log.error("Error");
			return null;
		} finally {
			serv.em.close();
		}
	}

	public List<Catalog> searchByYear(String anno) {
		try {
			var query = serv.em.createNamedQuery(Catalog.QUERY_SELECT_SEARCH_YEAR, Catalog.class);
			query.setParameter("anno", anno);
			List<Catalog> lis = query.getResultList();
			return lis;
		} catch (Exception e) {
			log.error("Error");
			return new ArrayList<Catalog>();
		} finally {
			serv.em.close();
		}
	}

	public List<Book> searchByAuthor(String autore) {
		try {
			var query = serv.em.createNamedQuery(Book.QUERY_SELECT_SEARCH_AUTHOR, Book.class);
			query.setParameter("autore", autore);
			List<Book> lis = query.getResultList();
			return lis;
		} catch (Exception e) {
			log.error("Error");
			return new ArrayList<Book>();
		} finally {
			serv.em.close();
		}
	}

	public List<Catalog> searchByTitle(String titolo) {
		try {
			var query = serv.em.createNamedQuery(Catalog.QUERY_SELECT_SEARCH_TITOLO, Catalog.class);
			query.setParameter("titolo", "%" + titolo + "%");
			List<Catalog> lis = query.getResultList();
			return lis;
		} catch (Exception e) {
			log.error("Error");
			return new ArrayList<Catalog>();
		} finally {
			serv.em.close();
		}
	}

}
