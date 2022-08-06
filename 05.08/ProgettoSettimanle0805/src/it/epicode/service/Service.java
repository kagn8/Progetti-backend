package it.epicode.service;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.epicode.dao.CatalogDAO;
import it.epicode.entities.library.Book;
import it.epicode.entities.library.Catalog;
import it.epicode.entities.library.Magazine;
import it.epicode.entities.library.Periodicity;
import it.epicode.entities.prestito.Loan;
import it.epicode.entities.prestito.User;
import it.epicode.utils.JpaUtil;

public class Service {
	public EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();

	public CatalogDAO catDao = new CatalogDAO();

	public Service() {
	}

//	GENERIAMO I VARI ELEMENTI CHE VOGLIAMO AGGIUNGERE AL NOSTRO CATALOGO
	Catalog book1 = new Book("1234", "Il Signore dei fornelli", "2001", 963, "Giorgio Mastrota", "Fantasy");
	Catalog book2 = new Book("5678", "Il Signore delle batterie", "2000", 763, "Giorgio Mastrota", "Adventure");
	Catalog book3 = new Book("9101", "Tre gambe e un uomo", "2012", 523, "Rocco", "Dramatic");
	Catalog book4 = new Book("1121", "Crash Bandicoot 2: Cortex Strike back", "1998", 876, "Naughty dog", "Adventure");
	Catalog book5 = new Book("4156", "Dragon quest XI S - Echi di un'era perduta ", "2022", 126, "Akira Toriyama",
			"Fantasy");
	Catalog magazine1 = new Magazine("1321", "Chi", "1999", 23, Periodicity.WEEKLY);
	Catalog magazine2 = new Magazine("2721", "Oggi", "2002", 43, Periodicity.WEEKLY);
	Catalog magazine3 = new Magazine("4381", "Gente", "2007", 51, Periodicity.MONTHLY);
	Catalog magazine4 = new Magazine("9321", "Topolino 2000", "2010", 22, Periodicity.SIXMONTHLY);
	Catalog magazine5 = new Magazine("4322", "The Amazing Spiderman", "2012", 63, Periodicity.MONTHLY);

	public User Mario = new User("Mario", "Mario", LocalDate.of(1960, 8, 5), 3266732);
	public User Luigi = new User("Luigi", "Mario", LocalDate.of(1960, 8, 5), 5464564);

	public void listMaker() {
//		LANCIANDO I VARI METODI ADD
		catDao.addToCatalog(book1);
		catDao.addToCatalog(book2);
		catDao.addToCatalog(book3);
		catDao.addToCatalog(book4);
		catDao.addToCatalog(book5);
		catDao.addToCatalog(magazine1);
		catDao.addToCatalog(magazine2);
		catDao.addToCatalog(magazine3);
		catDao.addToCatalog(magazine4);
		catDao.addToCatalog(magazine5);
	};

	public Loan loan1 = new Loan(Mario, book1, LocalDate.now());
	public Loan loan2 = new Loan(Luigi, book2, LocalDate.of(1998, 5, 21));
	public Loan loan3 = new Loan(Mario, book3, LocalDate.of(2011, 5, 21), LocalDate.of(2011, 5, 25));

}
