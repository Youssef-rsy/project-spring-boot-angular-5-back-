package icda.taf.projet.projetCoursRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import icda.taf.projet.projetCoursRest.Entity.Etudiant;

public interface EtudiantDao extends JpaRepository<Etudiant, Long> {

}
