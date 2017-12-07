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
@Table(name = "PRODUIT")
@NamedQueries({
		@NamedQuery(name = "Produit.findAll", query = " SELECT p FROM Produit p ORDER BY p.nomP ") })
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDP")
	private int idP;

	@Column(name = "NOM_P", nullable = false, length = 30)
	private String nomP;

	@Column(name = "RAYON", nullable = false, length = 30)
	private String rayon;

	public Produit(String nom, String rayon) {
		super();
		this.nomP = nom;
		this.rayon = rayon;
	}

	public Produit() {
	}

	public int getIdP() {
		return this.idP;
	}

	public String getNomP() {
		return this.nomP;
	}

	public String getRayon() {
		return rayon;
	}

//	@Override
//	public String toString() {
//		return "Monument [identifiant=" + identifiant + ", nom=" + nom
//				+ ", ville=" + ville + "]";
//	}
}
