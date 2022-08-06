package it.epicode.entities.prestito;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import it.epicode.entities.library.Catalog;

@Entity
@NamedQuery(name = Loan.QUERY_SELECT_RICERCA_PRESTITO, query = "SELECT a FROM Loan a WHERE a.utente.numeroDiTessera = :ntessera "
		+ "AND a.dataRestituzioneEffettiva IS NULL")
@NamedQuery(name = Loan.QUERY_SELECT_RICERCA_PRESTITO_SCADUTO, query = "SELECT a FROM Loan a WHERE a.actualLoanRepayment = null "
		+ "AND a.dataRestituzionePrevista < :data")
public class Loan {
	public static final String QUERY_SELECT_RICERCA_PRESTITO = "QUERY_SELECT_RICERCA_PRESTITO";
	public static final String QUERY_SELECT_RICERCA_PRESTITO_SCADUTO = "QUERY_SELECT_RICERCA_PRESTITO_SCADUTO";

	private int id;
	private User utente;
	private Catalog elementLoaned;
	private LocalDate startLoan;
	private LocalDate expectedLoanRepayment; // (calcolata automaticamente a 30 gg dalla data inizio prestito)
	private LocalDate actualLoanRepayment;

	public Loan(User utente, Catalog elementoPrestato, LocalDate dataInizioPrestito,
			LocalDate dataRestituzioneEffettiva) {
		this.utente = utente;
		this.elementLoaned = elementoPrestato;
		this.startLoan = dataInizioPrestito;
		this.expectedLoanRepayment = startLoan.plusDays(30);
		this.actualLoanRepayment = dataRestituzioneEffettiva;
	}

	public Loan(User utente, Catalog elementoPrestato, LocalDate dataInizioPrestito) {
		this.utente = utente;
		this.elementLoaned = elementoPrestato;
		this.startLoan = dataInizioPrestito;
		this.expectedLoanRepayment = startLoan.plusDays(30);

	}

	public Loan() {
	}

	@ManyToOne
	public User getUtente() {
		return utente;
	}
	@OneToOne
	public Catalog getElementoPrestato() {
		return elementLoaned;
	}

	public LocalDate getDataInizioPrestito() {
		return startLoan;
	}

	public LocalDate getDataRestituzionePrevista() {
		return expectedLoanRepayment;
	}

	public LocalDate getDataRestituzioneEffettiva() {
		return actualLoanRepayment;
	}

	public void setUtente(User utente) {
		this.utente = utente;
	}

	public void setElementoPrestato(Catalog elementoPrestato) {
		this.elementLoaned = elementoPrestato;
	}

	public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
		this.startLoan = dataInizioPrestito;
	}

	public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
		this.expectedLoanRepayment = dataRestituzionePrevista;
	}

	public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
		this.actualLoanRepayment = dataRestituzioneEffettiva;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Prestito [id=" + id + ", utente=" + utente + ", elementoPrestato=" + elementLoaned
				+ ", dataInizioPrestito=" + startLoan + ", dataRestituzionePrevista="
				+ expectedLoanRepayment + ", dataRestituzioneEffettiva=" + actualLoanRepayment + "]";
	}

	
}
