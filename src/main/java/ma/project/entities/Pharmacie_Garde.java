package ma.project.entities;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Pharmacie_Garde {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pharmacie_id")
	private Pharmacie pharmacie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "garde_id")
	private Garde garde;

	@Column(columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	private Date dateDebut;

	@Column(columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	private Date dateFin;

	public Pharmacie_Garde() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Garde getGarde() {
		return garde;
	}

	public void setGarde(Garde garde) {
		this.garde = garde;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
