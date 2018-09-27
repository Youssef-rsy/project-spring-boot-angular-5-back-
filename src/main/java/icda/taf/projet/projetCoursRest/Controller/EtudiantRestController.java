package icda.taf.projet.projetCoursRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import icda.taf.projet.projetCoursRest.Entity.Etudiant;
import icda.taf.projet.projetCoursRest.object.ObjectState;
import icda.taf.projet.projetCoursRest.object.ReturnedValue;
import icda.taf.projet.projetCoursRest.service.CoursServiceInteface;
import icda.taf.projet.projetCoursRest.service.EtudiantServiceInterfce;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EtudiantRestController {
	
	@Autowired
	private EtudiantServiceInterfce  etudiantservice;
	@Autowired
	private CoursServiceInteface courservice;
	private ReturnedValue<List<Etudiant>> lstEtudiant;
	private ReturnedValue<Etudiant> etudiant;
	private ReturnedValue<List<Cours>> lstcour;
	private List<Cours> lstcours;
	
	@PostMapping("/addetudiant")
	public ReturnedValue<List<Etudiant>> addCours(@RequestBody Etudiant etudiant){
		System.out.println(etudiant.getNom()  );
		System.out.println(etudiant.getPrenom() );
		System.out.println(etudiant.getSpecialite());
		System.out.println(etudiant.getAdresse().getRue());
		System.out.println(etudiant.getAdresse().getVille() );

		etudiantservice.addEtudiant(etudiant);
		lstEtudiant = new ReturnedValue<List<Etudiant>>();
		lstEtudiant.setValeur(etudiantservice.allEtudiant());
		lstEtudiant.setMessage("enregistrement avec succes");
		lstEtudiant.setEtat(ObjectState.success);
		return lstEtudiant;
	}
	
	public ReturnedValue<List<Etudiant>> lst(){
		lstEtudiant = new ReturnedValue<List<Etudiant>>();
		lstEtudiant.setValeur(etudiantservice.allEtudiant());
		lstEtudiant.setMessage("chargement avec succes");
		lstEtudiant.setEtat(ObjectState.success);
		return lstEtudiant;
	}
	
	@GetMapping("etudiants")
	public ReturnedValue<List<Etudiant>> listCours(){
		return lst();
	}
	
	@DeleteMapping(value="/deleteetudiant")
	public ReturnedValue<List<Etudiant>> deleteCours(long etudiantid ){
		etudiantservice.deleteEtudiant(etudiantid);
		return lst();
		
	}
	@RequestMapping(value="/updateEtudiant")
	public ReturnedValue<Etudiant> readEtudiant( String etudiantid ){
		System.out.println(etudiantid);
		etudiant = new ReturnedValue<Etudiant>(etudiantservice.getEtudiant(Long.parseLong(etudiantid)), ObjectState.success, "Chargemement du  ");
		return etudiant;
		
	}
	
	@PutMapping(value="updateinfosetudiant")
	public ReturnedValue<List<Etudiant>> updateetudiant(@RequestBody Etudiant etudiant){
		System.out.println(etudiant.getNom() +" "+ etudiant.getPrenom() +" "+etudiant.getSpecialite()+" "+etudiant.getAdresse().getRue()+" "+etudiant.getAdresse().getVille()+" " );
		Etudiant et = etudiantservice.getEtudiant(etudiant.getId());
		et.setNom(etudiant.getNom());
		et.setCours(etudiant.getCours());
		et.setSpecialite(etudiant.getSpecialite());
		et.setPrenom(etudiant.getPrenom());
		et.getAdresse().setRue(etudiant.getAdresse().getRue());
		et.getAdresse().setVille(etudiant.getAdresse().getVille());
		etudiantservice.updateEtudiant(etudiant.getId(), et);
		return lst();
	}
	@RequestMapping(value="affichercoursetudiant")
	public ReturnedValue<List<Cours>> affichercoursetudiant(long etudiantid ){
		Etudiant et = etudiantservice.getEtudiant(etudiantid);
		lstcour = new ReturnedValue<List<Cours>>();
		lstcour.setValeur(et.getCours());
		lstcour.setMessage("chargement avec succes");
		lstcour.setEtat(ObjectState.success);
		return lstcour;
	}
	
	@RequestMapping(value="/couraetud" )
	public ReturnedValue<List<Etudiant>> updateCouretudiant(long idetu , long cour){
		//System.out.println(etudiant.getNom() +" "+ etudiant.getPrenom() +" "+etudiant.getSpecialite()+" "+etudiant.getAdresse().getRue()+" "+etudiant.getAdresse().getVille()+" " );
		System.out.println(idetu);
		System.out.println(cour);
		Etudiant et = etudiantservice.getEtudiant(idetu);
		int nbr = 0;
		for(int i=0 ;i<et.getCours().size();i++){
			System.out.println(et.getCours().get(i).getId() != cour);
			if(et.getCours().get(i).getId() != cour){
				nbr++;
			}
		}
		if(nbr==0){
			et.getCours().add(courservice.getCours(cour));
		}
		etudiantservice.updateEtudiant(idetu,et);
		return lst();
	}
	
	
	@RequestMapping(value="/delcouraetud" )
	public  ReturnedValue<List<Etudiant>>  deleteCouretudiant(long idetu , long idc){
		//System.out.println(etudiant.getNom() +" "+ etudiant.getPrenom() +" "+etudiant.getSpecialite()+" "+etudiant.getAdresse().getRue()+" "+etudiant.getAdresse().getVille()+" " );
		System.out.println(idc);
		lstcours.clear();
		Etudiant et = etudiantservice.getEtudiant(idetu);
		System.out.println("1");
		for(int i=0 ;i<et.getCours().size();i++){
			System.out.println(et.getCours().get(i).getId() != idc);
			if(et.getCours().get(i).getId() != idc ){
				lstcours.add(et.getCours().get(i));
			}
		}
		System.out.println("2");
		et.getCours().clear();
		System.out.println("lenth ="+et.getCours().size());
		et.getCours().addAll(lstcours);
		System.out.println("lenth ="+et.getCours().size());
		etudiantservice.updateEtudiant(idetu,et);
		System.out.println("fin");
		return lst();
	}
	
	
}
