package icda.taf.projet.projetCoursRest.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import icda.taf.projet.projetCoursRest.Entity.*;
import icda.taf.projet.projetCoursRest.object.ObjectState;
import icda.taf.projet.projetCoursRest.object.ReturnedValue;
import icda.taf.projet.projetCoursRest.service.CoursServiceInteface;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CoursRestController {

	
	@Autowired
	CoursServiceInteface courservice;
	
	private ReturnedValue<Cours> cour;
	ObjectState obj;
	private ReturnedValue<List<Cours>> lstcour;
	
	
	@RequestMapping("addcour")
	public ReturnedValue<List<Cours>> addCours(String name){
		System.out.println(name);
		courservice.addCours(new Cours(name));
		List<Cours> lst = courservice.allCours();
		System.out.println(lst.size());
		lstcour = new ReturnedValue<List<Cours>>(lst, obj.success, "enregistrement avec succes");
		return lstcour;
	}
	@RequestMapping(value="cours" , produces = "application/json" )
	public ReturnedValue<List<Cours>> listCours(Model model){
		List<Cours> lst = courservice.allCours();
		System.out.println(lst.size());
		lstcour = new ReturnedValue<List<Cours>>(lst , obj.success, "enregistrement avec succes");
		return lstcour;
		
	}
	
	@RequestMapping(value="/deletecour")
	public  ReturnedValue<List<Cours>> deleteCours(long courid ){
		courservice.deleteCours(courid);
		List<Cours> lst = courservice.allCours();
		System.out.println(lst.size());
		lstcour = new ReturnedValue<List<Cours>>(lst, obj.success, "enregistrement avec succes");
		return lstcour;
		
	}
	
	@RequestMapping(value="/updatecour")
	public  ReturnedValue<Cours> readCours(long courid ){
		Cours c = courservice.getCours(courid);
		System.out.println(c.getNom());
		cour = new ReturnedValue<Cours>(c, obj.success, "Chargement avec succes");
		return cour;
		
	}
	@RequestMapping(value="updateinfos")
	public ReturnedValue<List<Cours>> updateCour(long idtoup , String name){
		System.out.println("id="+idtoup+"   nom="+name);
		Cours c=courservice.getCours(idtoup);
		c.setNom(name);
		courservice.updateCours(idtoup ,c);
		List<Cours> lst = courservice.allCours();
		System.out.println(lst.size());
		lstcour = new ReturnedValue<List<Cours>>(lst, obj.success, "enregistrement avec succes");
		return lstcour;
	}
	
	//listetudiant
	private ReturnedValue<List<Etudiant>> listetudiant;
	@RequestMapping(value="/listetudiant")
	public ReturnedValue<List<Etudiant>> listetudiant(long courid){
		Cours c  = courservice.getCours(courid);
		listetudiant = new ReturnedValue<List<Etudiant>>();
		listetudiant.setValeur(c.getEtudiants());
		listetudiant.setEtat(ObjectState.success);
		listetudiant.setMessage("list charger avec successe");
		return listetudiant;
	}
	
	
	@RequestMapping("listOfNonAssignedCours")
	public ReturnedValue<List<Cours>> listOfNonAssignedCours(){
		List<Cours> lst = courservice.listOfNonAssignedCours();
		System.out.println("<---------------------*******------------------>");
		System.out.println(lst.size());
		lstcour = new ReturnedValue<List<Cours>>(lst, obj.success, "enregistrement avec succes");
		return lstcour;
		
	}
}
