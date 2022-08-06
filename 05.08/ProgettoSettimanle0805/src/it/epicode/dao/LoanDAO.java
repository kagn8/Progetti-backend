package it.epicode.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.Program;
import it.epicode.entities.prestito.Loan;
import it.epicode.entities.prestito.User;
import it.epicode.service.Service;
import it.epicode.utils.JpaUtil;

public class LoanDAO {
	private static final Logger log = LoggerFactory.getLogger(Program.class);
	Service serv = new Service();

	
	public void addLoan(Loan prestito) {
		try {
			EntityTransaction transaction = serv.em.getTransaction();
			transaction.begin();
			serv.em.persist(prestito);
			transaction.commit();
		} catch (Exception e) {
			log.error("Error");
		} finally {
			serv.em.close();
		}
	}
	public void addUser(User utente) {
		try {
			EntityTransaction transaction = serv.em.getTransaction();
			transaction.begin();
			serv.em.persist(utente);
			transaction.commit();
		} catch (Exception e) {
			log.error("Error");
		} finally {
			serv.em.close();
		}
	}
	public List<Loan> searchLoanByCardNum(int numeroDiTessera) {
		try {
			var query = serv.em.createNamedQuery(Loan.QUERY_SELECT_RICERCA_PRESTITO, Loan.class);
			query.setParameter("ntessera", numeroDiTessera);
			List<Loan> lis = query.getResultList();
			return lis;
		} catch (Exception e) {
			log.error("Error");
			return new ArrayList<Loan>();
		} finally {
			serv.em.close();
		}
	}

	public List<Loan> searchUnpaidAndOverdueLoan() {
		try {
			var query = serv.em.createNamedQuery(Loan.QUERY_SELECT_RICERCA_PRESTITO_SCADUTO, Loan.class);
			query.setParameter("data", LocalDate.now());
			List<Loan> lis = query.getResultList();
			return lis;
		} catch (Exception e) {
			log.error("Error");
			return new ArrayList<Loan>();
		} finally {
			serv.em.close();
		}
	}
}
