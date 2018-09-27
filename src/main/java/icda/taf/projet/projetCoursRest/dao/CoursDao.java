package icda.taf.projet.projetCoursRest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import icda.taf.projet.projetCoursRest.Entity.Cours;
@Repository
public interface CoursDao extends JpaRepository<Cours , Long> {

	public Cours findByNom(String nom);
	public List<Cours> findByEnseignantIsNull();
	
}
