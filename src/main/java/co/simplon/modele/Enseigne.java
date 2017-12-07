package co.simplon.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ENSEIGNE")
@NamedQueries({
		@NamedQuery(name = "Enseigne.findAll", query = " SELECT e FROM Enseigne e ORDER BY e.nomE ") })
public class Enseigne {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDE")
	private int idE;

	@Column(name = "NOM_E", nullable = false, length = 30)
	private String nomE;

	@Column(name = "VILLE", nullable = false, length = 30)
	private String ville;

	public Enseigne(String nom, String ville) {
		super();
		this.nomE = nom;
		this.ville = ville;
	}

	public Enseigne() {
	}

	public int getIdE() {
		return this.idE;
	}

	public String getNomE() {
		return this.nomE;
	}

	public String getVille() {
		return ville;
	}

//	@Override
//	public String toString() {
//		return "Monument [identifiant=" + identifiant + ", nom=" + nom
//				+ ", ville=" + ville + "]";
//	}
}
