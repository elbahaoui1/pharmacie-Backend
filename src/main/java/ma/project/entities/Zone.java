package ma.project.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Zone {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String nom;
	@JsonIgnore 

	@OneToMany(mappedBy="zone",fetch = FetchType.EAGER)
	private List<Pharmacie> pharmacies;
	
	
	@ManyToOne

	@JsonIgnoreProperties("zones")
	private Ville ville;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Pharmacie> getPharmacies() {
		return pharmacies;
	}

	public void setPharmacies(List<Pharmacie> pharmacies) {
		this.pharmacies = pharmacies;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Zone() {
		super();
	}
	
	
}
