package icda.taf.projet.projetCoursRest.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cours {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	//@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL , fetch=FetchType.EAGER)
	@JoinColumn(name="fk_idEnseignant")
	private Enseignant enseignant;
	 @JsonIgnore
	@ManyToMany(mappedBy="cours", cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	private List<Etudiant>  etudiants=new ArrayList<>();
	
	
	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cours(String nom) {
		super();
		this.nom = nom;
	}
	
	public Cours(Long id, String nom, Enseignant enseignant, List<Etudiant> etudiants) {
		super();
		this.id = id;
		this.nom = nom;
		this.enseignant = enseignant;
		this.etudiants = etudiants;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	
	
}
