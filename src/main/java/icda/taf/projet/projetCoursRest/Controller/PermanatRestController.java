package icda.taf.projet.projetCoursRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import icda.taf.projet.projetCoursRest.Entity.Cours;
import icda.taf.projet.projetCoursRest.Entity.Enseignant;
import icda.taf.projet.projetCoursRest.Entity.Permanent;
import icda.taf.projet.projetCoursRest.service.CoursServiceInteface;
import icda.taf.projet.projetCoursRest.service.EnseignantServiceInterface;
import icda.taf.projet.projetCoursRest.service.PermantServiceInterface;

@RestController
@CrossOrigin(origins= "http://localhost:4200" , maxAge=3600)
public class PermanatRestController {
	@Autowired
	private PermantServiceInterface permanentservice;
	private List<Permanent> lstpermanent;
	
	
	@Autowired
	private CoursServiceInteface courservice;
	private List<Cours> lstcour ;
	private Cours cour;
	
	@Autowired
	private EnseignantServiceInterface ensservice;
	private Enseignant ens;
	
	@PostMapping(path = "/addpermanent" , consumes =  { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = "application/json")
	public List<Permanent> addCours( @RequestBody Permanent permanent){
		System.out.println(permanent.getNom() +" "+ permanent.getPrenom() +" "+permanent.getService()+" "+permanent.getGrade()+" "+permanent.getAdresse().getRue()+" "+permanent.getAdresse().getVille()+" " );
		permanentservice.addPermanent(permanent);
		lstpermanent = permanentservice.allPermanent();
		return lstpermanent;
	}
	
	@GetMapping(path="permanents" , produces = "application/json")
	public  List<Permanent> listCours(){
		lstpermanent = permanentservice.allPermanent();
		return listP();
		
	}
	public List<Permanent> listP(){
		lstpermanent = permanentservice.allPermanent();
		System.out.println("---------------->"+lstpermanent.size());
		return lstpermanent;
	}
	
	@DeleteMapping(value="/deletepermanent")
	public List<Permanent> deleteCours(long permanentid ){
		permanentservice.deletePermanent(permanentid);
		
		return listP();
		
	}

	@GetMapping(value="/updatepermanent")
	public  Permanent readPermanent( String permanentid ){
		System.out.println(permanentid);
		Permanent permanent = permanentservice.getPermanent(Long.parseLong(permanentid));
		System.out.println(permanent.getNom() +" "+ permanent.getPrenom() +" "+permanent.getService()+" "+permanent.getGrade()+" "+permanent.getAdresse().getRue()+" "+permanent.getAdresse().getVille()+" " );
		return permanent;
		
	}
	
	@RequestMapping(value="updateinfospermanent" , consumes =  { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public List<Permanent> updatePermanent(@RequestBody Permanent permanent){
		System.out.println(permanent.getNom() +" "+ permanent.getPrenom() +" "+permanent.getService()+" "+permanent.getGrade()+" "+permanent.getAdresse().getRue()+" "+permanent.getAdresse().getVille()+" " );
		
		Permanent et = permanentservice.getPermanent(permanent.getId());
		et.setNom(permanent.getNom());
		et.setCours(permanent.getCours());
		et.setService(permanent.getService());
		et.setGrade(permanent.getGrade());
		et.setPrenom(permanent.getPrenom());
		et.getAdresse().setRue(permanent.getAdresse().getRue());
		et.getAdresse().setVille(permanent.getAdresse().getVille());
		permanentservice.updatePermanent(permanent.getId() , et);
		
		return listP();
	}
	
	
	@RequestMapping(value="affichercourspermanent")
	public List<Cours> affichercoursPermanent(long permanentid ){
		Permanent et = permanentservice.getPermanent(permanentid);
		return et.getCours();
	}

	@RequestMapping(value="/courapermanent" )
	public List<Permanent>  updateCourPermanent(long idpermanent , long cour){
		System.out.println("debut de la methode courepermanent");
		System.out.println(cour);
		Permanent et = permanentservice.getPermanent(idpermanent);
		Cours cours = courservice.getCours(cour);
		cours.setEnseignant(ensservice.getEnseignant(idpermanent));
		courservice.updateCours(cour ,cours);
		System.out.println("fin de la methode courepermanat");
		return listP();
	}
	
	@RequestMapping(value="/delcourapermanent" )
	public  List<Permanent>  deleteCourPermanent(long idpermanent , long idc ){
		System.out.println("///////////////////////////////////////////");
		//System.out.println(Permanent.getNom() +" "+ Permanent.getPrenom() +" "+Permanent.getSpecialite()+" "+Permanent.getAdresse().getRue()+" "+Permanent.getAdresse().getVille()+" " );
		System.out.println(idc);
		Cours cours = courservice.getCours(idc);
		cours.setEnseignant(null);
		courservice.updateCours(cours.getId() , cours);
		System.out.println("fin");
		lstpermanent = permanentservice.allPermanent();
		return listP();
	}
	
}
