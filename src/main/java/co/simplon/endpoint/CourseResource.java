package co.simplon.endpoint;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import co.simplon.dao.AchatDao;
import co.simplon.modele.Achat;
import co.simplon.modele.Course;

@Path("/courses")
@RequestScoped
public class CourseResource {

	@Inject
	private EntityManager entityManager;

	@Inject
	private AchatDao achatDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getCourses() {
		List<Course> courses = entityManager.createNamedQuery("Course.findAll", Course.class).getResultList();
		return courses;
	}

	@POST
	@Path("{idC}/achat/{idP}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAchat(@PathParam("idC") int idC, @PathParam("idP") int idP, Achat achatACreer) {
		Achat achat = achatDao.createAchatForCourse(achatACreer, idC, idP);
		return Response.status(Status.BAD_REQUEST).build();
	}

}
