package icda.taf.projet.projetCoursRest.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue(value="ETUDIANT")
public class Etudiant extends Personne{
	private String specialite;
	@JsonIgnore
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Cours> cours =new ArrayList<>();
	
	public Etudiant() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Etudiant(Long id, String nom, String prenom, Adresse adresse) {
		super(id, nom, prenom, adresse);
		// TODO Auto-generated constructor stub
	}
	public Etudiant(Long id, String nom, String prenom, Adresse adresse, String specialite, List<Cours> cours) {
		super(id, nom, prenom, adresse);
		this.specialite = specialite;
		this.cours = cours;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public List<Cours> getCours() {
		return cours;
	}
	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}



}
