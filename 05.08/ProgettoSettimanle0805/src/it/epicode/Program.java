package it.epicode;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.dao.CatalogDAO;
import it.epicode.dao.LoanDAO;
import it.epicode.entities.library.Catalog;
import it.epicode.entities.prestito.Loan;
import it.epicode.service.Service;

public class Program {
	public static void main(String[] args) {

		final Logger Log = LoggerFactory.getLogger(Program.class);

		Service serv = new Service();

		var catDao = new CatalogDAO();
		var loanDao = new LoanDAO();

		serv.listMaker();

		catDao.removeToCatalogByIsbn("1234");

		Catalog book1 = catDao.searchByIsbn("5678");
		Log.info(book1.toString());

		Catalog book2 = catDao.searchByIsbn("5678");
		Log.info(book2.toString());

		Catalog book3 = catDao.searchByIsbn("5678");
		Log.info(book3.toString());

		List<Catalog> searchedByYear = catDao.searchByYear("2000");
		for (Catalog e : searchedByYear) {
			Log.info(e.toString());
		}

		List<Catalog> searchedByAuthor = catDao.searchByYear("Giorgio Mastrota");
		for (Catalog e : searchedByAuthor) {
			Log.info(e.toString());
		}

		List<Catalog> searchedByTitle = catDao.searchByYear("Signore");
		for (Catalog e : searchedByTitle) {
			Log.info(e.toString());
		}

		loanDao.addUser(serv.Mario);
		loanDao.addUser(serv.Luigi);

		loanDao.addLoan(serv.loan1);
		loanDao.addLoan(serv.loan2);
		loanDao.addLoan(serv.loan3);

		List<Loan> listOfLoan1 = loanDao.searchLoanByCardNum(serv.Mario.getNumeroDiTessera());
		for (Loan p : listOfLoan1) {
			Log.info(p.toString());
		}

		List<Loan> listOfLoan2 = loanDao.searchUnpaidAndOverdueLoan();
		for (Loan p : listOfLoan2) {
			Log.info(p.toString());
		}

	}
}
