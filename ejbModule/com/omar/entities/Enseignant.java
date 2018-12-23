package com.omar.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity(name="enseignant")
public class Enseignant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "nomComplet", nullable = false)
	private String nomComplet;
	
	@Column(name = "login", nullable = false, unique = true)
	private String login;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "password", nullable = false)
	private String password;
	
	public Enseignant() {
	}
	
	public Enseignant(String nomComplet, String login, String password) {
		
		this.nomComplet = nomComplet;
		this.login = login;
		this.password = password;
	}
	
	
	/*
	 * BEGIN TABLE ENSEIGNEMENT RELATION
	 * */
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	}, fetch = FetchType.EAGER)
	@JoinTable(name = "enseignement",
	joinColumns = @JoinColumn(name = "idEns"),
	inverseJoinColumns = @JoinColumn(name = "idMat"))
	private Set<Matiere> matieres = new HashSet<>();

	/*
	 * END TABLE ENSEIGNEMENT RELATION
	 * */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enseignant enseignant = (Enseignant) o;
        return Objects.equals(id, enseignant.id);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(id + nomComplet);
    }

	@Override
	public String toString() {
		return "Enseignant [id=" + id + ", nomComplet=" + nomComplet + ", login=" + login + ", password=" + password
				+ "]";
	}
   
    
}
