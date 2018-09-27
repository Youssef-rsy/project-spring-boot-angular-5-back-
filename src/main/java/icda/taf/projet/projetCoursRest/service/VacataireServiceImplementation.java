package icda.taf.projet.projetCoursRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icda.taf.projet.projetCoursRest.Entity.Vacataire;
import icda.taf.projet.projetCoursRest.dao.VacataireDao;
@Service
public class VacataireServiceImplementation implements VacataireServiceInterface {

	@Autowired
	private VacataireDao dao;
	private Vacataire vacataire;
	
	@Override
	public Vacataire addVacataire(Vacataire vacataire) {
		// TODO Auto-generated method stub
		return dao.save(vacataire);
	}

	@Override
	public Vacataire updateVacataire(long id, Vacataire vacataire) {
		// TODO Auto-generated method stub
		this.vacataire = getVacataire(id);
		this.vacataire = vacataire;
		dao.flush();
		return this.vacataire;
	}

	@Override
	public List<Vacataire> allVacataire() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteVacataire(long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Vacataire getVacataire(long id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}


	

}
