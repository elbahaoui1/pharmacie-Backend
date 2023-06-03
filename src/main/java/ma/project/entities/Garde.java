package ma.project.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Garde {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;

	@OneToMany(mappedBy = "garde", fetch = FetchType.LAZY)
	private List<Pharmacie_Garde> pharmacieGardes;
	
	public List<Pharmacie_Garde> getPharmacieGardes() {
		return pharmacieGardes;
	}

	public void setPharmacieGardes(List<Pharmacie_Garde> pharmacieGardes) {
		this.pharmacieGardes = pharmacieGardes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Garde() {
		super();
	}

}
