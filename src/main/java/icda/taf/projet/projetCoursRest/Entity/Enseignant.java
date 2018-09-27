package icda.taf.projet.projetCoursRest.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue(value="ENSEIGNANT")
public class Enseignant extends Personne{
	private String service;
	 @JsonIgnore
	@OneToMany(mappedBy="enseignant", cascade=CascadeType.ALL )
	private List<Cours>  cours=new ArrayList<>();
	
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enseignant(Long id, String nom, String prenom, Adresse adresse) {
		super(id, nom, prenom, adresse);
		// TODO Auto-generated constructor stub
	}
	
	
	public Enseignant(Long id, String nom, String prenom, Adresse adresse, String service) {
		super(id, nom, prenom, adresse);
		this.service = service;
	}
	public Enseignant(Long id, String nom, String prenom, Adresse adresse, String service, List<Cours> cours) {
		super(id, nom, prenom, adresse);
		this.service = service;
		this.cours = cours;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public List<Cours> getCours() {
		return cours;
	}
	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}
	

}
