package icda.taf.projet.projetCoursRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import icda.taf.projet.projetCoursRest.Entity.Enseignant;

public interface EnseignatDao extends JpaRepository<Enseignant, Long> {

}
