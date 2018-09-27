package icda.taf.projet.projetCoursRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import icda.taf.projet.projetCoursRest.Entity.Vacataire;

public interface VacataireDao extends JpaRepository<Vacataire, Long> {

}
