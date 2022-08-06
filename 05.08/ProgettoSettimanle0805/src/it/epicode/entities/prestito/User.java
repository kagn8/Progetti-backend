package it.epicode.entities.prestito;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	private int id;
	private String name;
	private String surname;
	private LocalDate birthday;
	private int cardMemberNumber;

	public User(String nome, String cognome, LocalDate dataDiNascita, int numeroDiTessera) {
		super();
		this.name = nome;
		this.surname = cognome;
		this.birthday = dataDiNascita;
		this.cardMemberNumber = numeroDiTessera;
	}

	public User() {
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public int getNumeroDiTessera() {
		return cardMemberNumber;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public void setCognome(String cognome) {
		this.surname = cognome;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.birthday = dataDiNascita;
	}

	public void setNumeroDiTessera(int numeroDiTessera) {
		this.cardMemberNumber = numeroDiTessera;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
