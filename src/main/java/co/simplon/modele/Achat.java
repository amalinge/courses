package co.simplon.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ACHAT")
@NamedQueries({
		@NamedQuery(name = "Achat.findAll", query = " SELECT a FROM Achat a ") })
//		@NamedQuery(name = "Monument.findAllByVilleId", query = " SELECT m FROM Monument m JOIN m.ville v WHERE v.id = :id ORDER BY m.nom "),
//		@NamedQuery(name = "Monument.deleteById", query = " DELETE FROM Monument m WHERE m.identifiant = :id") })
public class Achat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDA")
	private int idA;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "COURSE_IDC")
	private Course course;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "PRODUIT_IDP")
	private Produit produit;

	@Column(name = "QTE", nullable = false)
	private int qte;

	public Achat(Course course, Produit produit, int qte) {
		super();
		this.course = course;
		this.produit = produit;
		this.qte = qte;
	}

	public Achat() {
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

//	@Override
//	public String toString() {
//		return "Monument [identifiant=" + identifiant + ", nom=" + nom
//				+ ", ville=" + ville + "]";
//	}
}
