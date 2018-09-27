package icda.taf.projet.projetCoursRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import icda.taf.projet.projetCoursRest.Entity.Personne;

public interface PersonneDao extends JpaRepository<Personne, Long>{

}
