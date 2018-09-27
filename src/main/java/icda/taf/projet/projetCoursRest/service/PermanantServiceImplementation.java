package icda.taf.projet.projetCoursRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icda.taf.projet.projetCoursRest.Entity.Permanent;
import icda.taf.projet.projetCoursRest.dao.PermanenttDao;


@Service
public class PermanantServiceImplementation implements PermantServiceInterface{

	@Autowired
	private PermanenttDao dao;
	private Permanent permanant;
	
	@Override
	public Permanent addPermanent(Permanent permanent) {
		// TODO Auto-generated method stub
		return dao.save(permanent);
	}

	@Override
	public Permanent updatePermanent(long id, Permanent permanent) {
		// TODO Auto-generated method stub
		this.permanant  =  dao.findOne(id);
		this.permanant = permanent ;
		dao.flush();
		return this.permanant;
	}

	@Override
	public List<Permanent> allPermanent() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deletePermanent(long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Permanent getPermanent(long id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}



}
