package icda.taf.projet.projetCoursRest.object;

import icda.taf.projet.projetCoursRest.object.ObjectState;

public class ReturnedValue<T> {

	private T valeur ;
	private ObjectState etat;
	private String message ;
	
	public ReturnedValue(T valeur, ObjectState etat, String message) {
		super();
		this.valeur = valeur;
		this.etat = etat;
		this.message = message;
	}

	public ReturnedValue() {
		// TODO Auto-generated constructor stub
	}

	public ObjectState getEtat() {
		return etat;
	}

	public void setEtat(ObjectState etat) {
		this.etat = etat;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getValeur() {
		return valeur;
	}

	public void setValeur(T valeur) {
		this.valeur = valeur;
	}
	
	
}
