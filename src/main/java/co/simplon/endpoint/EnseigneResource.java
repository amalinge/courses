package co.simplon.endpoint;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.simplon.modele.Enseigne;

@Path("/enseignes")
@RequestScoped
public class EnseigneResource {

	@Inject
	private EntityManager entityManager;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Enseigne> getEnseignes() {
		List<Enseigne> enseignes = entityManager.createNamedQuery("Enseigne.findAll", Enseigne.class).getResultList();;
		return enseignes;
	}
}
