package ma.project.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;

@Embeddable
public class Pharmacie_Garde_PK implements Serializable {

	public Pharmacie_Garde_PK(int pharmacie, int garde, Date dateDebut, Date dateFin) {
		super();
		this.pharmacie = pharmacie;
		this.garde = garde;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	private int pharmacie;
	private int garde;
	private Date dateDebut;
	private Date dateFin;
	public Pharmacie_Garde_PK() {
		super();
	}
	public int getPharmacie() {
		return pharmacie;
	}
	public void setPharmacie(int pharmacie) {
		this.pharmacie = pharmacie;
	}
	public int getGarde() {
		return garde;
	}
	public void setGarde(int garde) {
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
