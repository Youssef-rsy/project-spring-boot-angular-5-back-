package icda.taf.projet.projetCoursRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icda.taf.projet.projetCoursRest.Entity.Enseignant;
import icda.taf.projet.projetCoursRest.dao.EnseignatDao;
@Service
public class EnseignantServiceImplementation implements EnseignantServiceInterface {

	@Autowired
	private EnseignatDao dao;
	private Enseignant ensaignant;
	
	@Override
	public Enseignant addEnseignant(Enseignant enseignant) {
		// TODO Auto-generated method stub
		ensaignant = dao.save(enseignant);
		return ensaignant;
	}
	
	@Override
	public Enseignant updateEnseignant(long id , Enseignant enseignant) {
		// TODO Auto-generated method stub
		enseignant = dao.findOne(id);
		this.ensaignant = enseignant;
		return this.ensaignant;
	}
	
	@Override
	public List<Enseignant> allEnseignant() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	@Override
	public void deleteEnseignant(long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}
	
	@Override
	public Enseignant getEnseignant(long id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}
	
	

}
