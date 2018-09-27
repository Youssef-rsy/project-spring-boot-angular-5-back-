package icda.taf.projet.projetCoursRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import icda.taf.projet.projetCoursRest.Entity.Cours;
import icda.taf.projet.projetCoursRest.Entity.Enseignant;
import icda.taf.projet.projetCoursRest.Entity.Vacataire;
import icda.taf.projet.projetCoursRest.service.CoursServiceInteface;
import icda.taf.projet.projetCoursRest.service.EnseignantServiceInterface;
import icda.taf.projet.projetCoursRest.service.PermantServiceInterface;
import icda.taf.projet.projetCoursRest.service.VacataireServiceInterface;
@CrossOrigin(origins= "http://localhost:4200" , maxAge=3600)
@RestController
public class VacataireRestController {
	@Autowired
	private VacataireServiceInterface vacataireservice;
	private List<Vacataire> lstvacataire;
	
	
	@Autowired
	private CoursServiceInteface courservice;
	private List<Cours> lstcour ;
	private Cours cour;
	
	@Autowired
	private EnseignantServiceInterface ensservice;
	private Enseignant ens;
	
	@PostMapping(path = "/addvacataire" , consumes =  { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = "application/json")
	public List<Vacataire> addCours( @RequestBody Vacataire vacataire){
		System.out.println(vacataire.getNom() +" "+ vacataire.getPrenom() +" "+vacataire.getService()+" "+vacataire.getEmployeur()+" "+vacataire.getAdresse().getRue()+" "+vacataire.getAdresse().getVille()+" " );
		vacataireservice.addVacataire(vacataire);
		lstvacataire = vacataireservice.allVacataire();
		return lstvacataire;
	}
	
	@GetMapping(path="vacataires" , produces = "application/json")
	public  List<Vacataire> listCours(){
		lstvacataire = vacataireservice.allVacataire();
		return listP();
		
	}
	public List<Vacataire> listP(){
		lstvacataire = vacataireservice.allVacataire();
		System.out.println("---------------->"+lstvacataire.size());
		return lstvacataire;
	}
	
	@DeleteMapping(value="/deletevacataire")
	public List<Vacataire> deleteCours(long vacataireid ){
		vacataireservice.deleteVacataire(vacataireid);
		
		return listP();
		
	}

	@GetMapping(value="/updatevacataire")
	public  Vacataire readvacataire( String vacataireid ){
		System.out.println(vacataireid);
		Vacataire vacataire = vacataireservice.getVacataire(Long.parseLong(vacataireid));
		System.out.println(vacataire.getNom() +" "+ vacataire.getPrenom() +" "+vacataire.getService()+" "+vacataire.getEmployeur()+" "+vacataire.getAdresse().getRue()+" "+vacataire.getAdresse().getVille()+" " );
		return vacataire;
		
	}
	
	@RequestMapping(value="updateinfosvacataire" , consumes =  { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public List<Vacataire> updatevacataire(@RequestBody Vacataire vacataire){
		System.out.println(vacataire.getNom() +" "+ vacataire.getPrenom() +" "+vacataire.getService()+" "+vacataire.getEmployeur()+" "+vacataire.getAdresse().getRue()+" "+vacataire.getAdresse().getVille()+" " );
		
		Vacataire et = vacataireservice.getVacataire(vacataire.getId());
		et.setNom(vacataire.getNom());
		et.setCours(vacataire.getCours());
		et.setService(vacataire.getService());
		et.setEmployeur(vacataire.getEmployeur());
		et.setPrenom(vacataire.getPrenom());
		et.getAdresse().setRue(vacataire.getAdresse().getRue());
		et.getAdresse().setVille(vacataire.getAdresse().getVille());
		vacataireservice.updateVacataire(vacataire.getId() , et);
		
		return listP();
	}
	
	
	@RequestMapping(value="affichercoursvacataire")
	public List<Cours> affichercoursvacataire(long vacataireid ){
		Vacataire et = vacataireservice.getVacataire(vacataireid);
		return et.getCours();
	}

	@RequestMapping(value="/couravacataire" )
	public List<Vacataire>  updateCourvacataire(long idvacataire , long cour){
		System.out.println("debut de la methode courevacataire");
		System.out.println(cour);
		Vacataire et = vacataireservice.getVacataire(idvacataire);
		Cours cours = courservice.getCours(cour);
		cours.setEnseignant(ensservice.getEnseignant(idvacataire));
		courservice.updateCours(cour ,cours);
		System.out.println("fin de la methode courepermanat");
		return listP();
	}
	
	@RequestMapping(value="/delcouravacataire" )
	public  List<Vacataire>  deleteCourvacataire(long idvacataire , long idc ){
		System.out.println("///////////////////////////////////////////");
		//System.out.println(vacataire.getNom() +" "+ vacataire.getPrenom() +" "+vacataire.getSpecialite()+" "+vacataire.getAdresse().getRue()+" "+vacataire.getAdresse().getVille()+" " );
		System.out.println(idc);
		Cours cours = courservice.getCours(idc);
		cours.setEnseignant(null);
		courservice.updateCours(cours.getId() , cours);
		System.out.println("fin");
		lstvacataire = vacataireservice.allVacataire();
		return listP();
	}
	
}
