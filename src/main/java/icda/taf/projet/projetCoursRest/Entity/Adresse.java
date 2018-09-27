package icda.taf.projet.projetCoursRest.Entity;


import javax.persistence.*;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	private String rue;
	private String ville;
	
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Adresse(Long id, String rue, String ville) {
		super();
		this.id = id;
		this.rue = rue;
		this.ville = ville;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	



}
