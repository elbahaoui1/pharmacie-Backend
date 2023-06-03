package ma.project.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Pharmacie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	private String nom;
	private double lon;
	private double lat;
	private String adresse ;
	
	@ManyToOne
	@JsonIgnoreProperties("pharmacie")
	private Zone zone;
	
	@ManyToMany
	
	@JoinTable(
			name="User_Pharmacie", joinColumns = {@JoinColumn(name="pharmacie_id")}, inverseJoinColumns = {@JoinColumn(name="user_id")})
	@JsonIgnore 
	private List<User> user;
	
	@JsonIgnore
	
	@JsonIgnoreProperties("pharmacie")
	@OneToMany(mappedBy = "pharmacie", fetch = FetchType.LAZY)
	private List<Pharmacie_Garde> pharmacieGardes;
	
	


	public List<Pharmacie_Garde> getPharmacieGardes() {
		return pharmacieGardes;
	}

	public void setPharmacieGardes(List<Pharmacie_Garde> pharmacieGardes) {
		this.pharmacieGardes = pharmacieGardes;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

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

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}





	public Pharmacie() {
		super();
	}
	
	
	
}
