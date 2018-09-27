package icda.taf.projet.projetCoursRest.service;

import java.util.List;

import icda.taf.projet.projetCoursRest.Entity.Vacataire;

public interface VacataireServiceInterface {
	public Vacataire addVacataire(Vacataire vacataire);
	public Vacataire updateVacataire(long id ,Vacataire vacataire);
	public List<Vacataire> allVacataire();
	public void deleteVacataire(long id);
	public Vacataire getVacataire(long id);
}
