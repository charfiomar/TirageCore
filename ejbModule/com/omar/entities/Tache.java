	package com.omar.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tache
 *
 */
@Entity(name = "tache")
public class Tache implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "dateCreation", nullable = false)
	private Date dateCreation = new Date();
	
	@Column(name = "dateRecuperation", nullable = false)
	private Date dateRecuperation;

	@Column(name = "nbCopies", nullable = false)
	private Short nbCopies;
	
	@Column(name = "fileName")
	private String fileName;
	
	@Column(name = "terminee", nullable=false)
	private boolean terminee = false;
	
	public Tache() {
		super();
	}
	
	public Tache(Date dateRecuperation, Short nbCopies){
		this.dateRecuperation = dateRecuperation;
		this.nbCopies = nbCopies;
	}
	
	@ManyToOne
	@JoinColumn(name = "idMat", nullable = false)
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name = "idEns", nullable = false)
	private Enseignant enseignant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateRecuperation() {
		return dateRecuperation;
	}

	public void setDateRecuperation(Date dateRecuperation) {
		this.dateRecuperation = dateRecuperation;
	}

	public Short getNbCopies() {
		return nbCopies;
	}

	public void setNbCopies(Short nbCopies) {
		this.nbCopies = nbCopies;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isTerminee() {
		return terminee;
	}

	public void setTerminee(boolean terminee) {
		this.terminee = terminee;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	@Override
	public String toString() {
		return "Tache [id=" + id + ", dateCreation=" + dateCreation + ", dateRecuperation=" + dateRecuperation
				+ ", nbCopies=" + nbCopies + ", fileName=" + fileName + ", terminee=" + terminee + ", matiere="
				+ matiere + ", enseignant=" + enseignant + "]";
	}
	
	
	
}
