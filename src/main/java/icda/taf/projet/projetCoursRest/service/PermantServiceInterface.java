package icda.taf.projet.projetCoursRest.service;

import java.util.List;

import icda.taf.projet.projetCoursRest.Entity.Permanent;

public interface PermantServiceInterface {
	public Permanent addPermanent(Permanent permanent);
	public Permanent updatePermanent(long id ,Permanent permanent);
	public List<Permanent> allPermanent();
	public void deletePermanent(long id);
	public Permanent getPermanent(long id);
}
