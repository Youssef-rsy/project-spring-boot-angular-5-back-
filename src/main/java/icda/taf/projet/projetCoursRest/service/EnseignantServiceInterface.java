package icda.taf.projet.projetCoursRest.service;

import java.util.List;

import icda.taf.projet.projetCoursRest.Entity.Enseignant;

public interface EnseignantServiceInterface {
	public Enseignant addEnseignant(Enseignant enseignant);
	public Enseignant updateEnseignant(long id ,Enseignant enseignant);
	public List<Enseignant> allEnseignant();
	public void deleteEnseignant(long id);
	public Enseignant getEnseignant(long id);
}
