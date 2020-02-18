package com.sda.latnikovd.springbootapp.modules.authors;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;

	@Column
	private String surname;

	@Column(name = "birth_date")
	private Date birthDate;

	public Author() {
	}

	public Author(final String name, final String surname, final Date birthDate) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Author{" + "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", birthDate=" + birthDate + '}';
	}
}
