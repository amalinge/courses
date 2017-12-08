package co.simplon.endpoint;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.simplon.modele.Produit;

@Path("/produits")
@RequestScoped
public class ProduitResource {

	@Inject
	private EntityManager entityManager;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getProduits() {
		List<Produit> produits = entityManager.createNamedQuery("Produit.findAll", Produit.class).getResultList();;
		return produits;
	}
}
