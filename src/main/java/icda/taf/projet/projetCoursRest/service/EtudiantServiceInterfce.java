package icda.taf.projet.projetCoursRest.service;

import java.util.List;

import icda.taf.projet.projetCoursRest.Entity.Etudiant;

public interface EtudiantServiceInterfce {
	public Etudiant addEtudiant(Etudiant etudiant);
	public Etudiant updateEtudiant(long id , Etudiant etudiant);
	public List<Etudiant> allEtudiant();
	public void deleteEtudiant(long id);
	public Etudiant getEtudiant(long id);
}
