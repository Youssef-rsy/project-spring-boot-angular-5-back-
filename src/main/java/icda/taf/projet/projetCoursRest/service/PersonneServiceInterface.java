package icda.taf.projet.projetCoursRest.service;

import java.util.List;

import icda.taf.projet.projetCoursRest.Entity.Personne;

public interface PersonneServiceInterface {
	public Personne addPersonne(Personne personne);
	public Personne updatePersonne(long id , Personne personne);
	public List<Personne> allPersonne();
	public void deletePersonne(long id);
	public Personne getPersonne(long id);
}
