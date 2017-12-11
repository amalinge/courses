package co.simplon.modele;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "COURSE")
@NamedQueries({
		@NamedQuery(name = "Course.findAll", query = " SELECT c.date, e.nomE, e.ville FROM Course c JOIN c.enseigne e ORDER BY c.date ") })
//		@NamedQuery(name = "Monument.findAllByVilleId", query = " SELECT m FROM Monument m JOIN m.ville v WHERE v.id = :id ORDER BY m.nom "),
//		@NamedQuery(name = "Monument.deleteById", query = " DELETE FROM Monument m WHERE m.identifiant = :id") })
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDC")
	private int idC;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "IDE")
	private Enseigne enseigne;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name = "DATE")
	private Date date;

	public Course(Enseigne enseigne, Date date) {
		super();
		this.enseigne = enseigne;
		this.date = date;
	}

	public Course() {
	}

	public int getIdC() {
		return idC;
	}

	public Enseigne getEnseigne() {
		return enseigne;
	}

	public void setEnseigne(Enseigne enseigne) {
		this.enseigne = enseigne;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	@Override
//	public String toString() {
//		return "Monument [identifiant=" + identifiant + ", nom=" + nom
//				+ ", ville=" + ville + "]";
//	}
}
