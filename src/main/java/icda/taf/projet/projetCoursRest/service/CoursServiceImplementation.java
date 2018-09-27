package icda.taf.projet.projetCoursRest.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Service;
import icda.taf.projet.projetCoursRest.Entity.Cours;
import icda.taf.projet.projetCoursRest.dao.CoursDao;
@Service
public class CoursServiceImplementation implements CoursServiceInteface {

	@Autowired
	private CoursDao dao;
	private Cours cour;
	@Override
	public Cours addCours(Cours cours) {
		// TODO Auto-generated method stub
		return dao.save(cours);
	}

	@Override
	public Cours updateCours(long id, Cours cours) {
		// TODO Auto-generated method stub
		cour = dao.findOne(id);
		cour = cours;
		dao.flush();
		return cour; 
	}

	@Override
	public List<Cours> allCours() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteCours(long id) {
		// TODO Auto-generated method stub
		dao.delete(dao.findOne(id));;
	}

	@Override
	public Cours getCours(long id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

	@Override
	public Cours getCoursByNom(String nom) {
		// TODO Auto-generated method stub
		return dao.findByNom(nom);
	}

	@Override
	public List<Cours> listOfNonAssignedCours() {
		// TODO Auto-generated method stub
		return dao.findByEnseignantIsNull();
	}

}
