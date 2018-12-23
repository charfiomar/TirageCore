package com.omar.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Matiere
 *
 */
@Entity(name = "matiere")
public class Matiere implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "libelle", nullable = false)
	private String libelle;

	public Matiere() {
	}

	public Matiere(String libelle) {
		this.libelle = libelle;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Matiere matiere = (Matiere) o;
		return Objects.equals(libelle, matiere.libelle);
	}

	@Override
	public int hashCode() {
		return Objects.hash(libelle);
	}
}
