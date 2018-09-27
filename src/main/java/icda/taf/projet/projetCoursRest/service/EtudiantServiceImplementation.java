package icda.taf.projet.projetCoursRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icda.taf.projet.projetCoursRest.Entity.Etudiant;
import icda.taf.projet.projetCoursRest.dao.EtudiantDao;

@Service
public class EtudiantServiceImplementation implements EtudiantServiceInterfce {

	
	@Autowired
	private EtudiantDao dao;
	private Etudiant etudiant;
	
	@Override
	public Etudiant addEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		return dao.save(etudiant);
	}

	@Override
	public Etudiant updateEtudiant(long id , Etudiant etudiant) {
		// TODO Auto-generated method stub
		this.etudiant = dao.findOne(id);
		this.etudiant = etudiant;
		dao.save(etudiant);
		return this.etudiant;
	}

	@Override
	public List<Etudiant> allEtudiant() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteEtudiant(long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Etudiant getEtudiant(long id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

	

}
