package co.simplon.endpoint;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.simplon.dao.AchatDao;
import co.simplon.modele.Achat;

@Path("/achats")
@RequestScoped
public class AchatResource {

	@Inject
	private EntityManager entityManager;

	@GET
	@Path("{idC}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Achat> getAchatsByCourse(@PathParam("idC") int idC) {
		List<Achat> achats = entityManager.createNamedQuery("Achat.findAllByCourse", Achat.class).setParameter("idC", idC).getResultList();
		return achats;
	}

}
