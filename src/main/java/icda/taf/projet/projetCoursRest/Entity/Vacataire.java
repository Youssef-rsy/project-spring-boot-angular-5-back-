package icda.taf.projet.projetCoursRest.Entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="VACATAIRE")
public class Vacataire  extends Enseignant {
private String employeur;

public Vacataire() {
	super();
	// TODO Auto-generated constructor stub
}

public Vacataire(Long id, String nom, String prenom, Adresse adresse, String service, List<Cours> cours) {
	super(id, nom, prenom, adresse, service, cours);
	// TODO Auto-generated constructor stub
}

public Vacataire(Long id, String nom, String prenom, Adresse adresse) {
	super(id, nom, prenom, adresse);
	// TODO Auto-generated constructor stub
}

public Vacataire(Long id, String nom, String prenom, Adresse adresse, String service, List<Cours> cours,
		String employeur) {
	super(id, nom, prenom, adresse, service, cours);
	this.employeur = employeur;
}

public String getEmployeur() {
	return employeur;
}

public void setEmployeur(String employeur) {
	this.employeur = employeur;
}



}
