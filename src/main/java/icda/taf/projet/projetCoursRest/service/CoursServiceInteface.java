package icda.taf.projet.projetCoursRest.service;

import java.util.List;

import icda.taf.projet.projetCoursRest.Entity.Cours;

public interface CoursServiceInteface {
	public Cours addCours(Cours cours);
	public Cours updateCours(long id , Cours cours);
	public List<Cours> allCours();
	public List<Cours> listOfNonAssignedCours() ;
	public void deleteCours(long id);
	public Cours getCours(long id);
	public Cours getCoursByNom(String nom);
}
