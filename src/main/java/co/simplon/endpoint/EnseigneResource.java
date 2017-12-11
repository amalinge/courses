package co.simplon.endpoint;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import co.simplon.dao.CourseDao;
import co.simplon.modele.Course;
import co.simplon.modele.Enseigne;

@Path("/enseignes")
@RequestScoped
public class EnseigneResource {

	@Inject
	private EntityManager entityManager;

	@Inject
	private CourseDao courseDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Enseigne> getEnseignes() {
		List<Enseigne> enseignes = entityManager.createNamedQuery("Enseigne.findAll", Enseigne.class).getResultList();;
		return enseignes;
	}

	@POST
	@Path("{idE}/course")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCourse(@PathParam("idE") int idE, Course courseACreer) {
		Course course = courseDao.createCourseForEnseigne(courseACreer, idE);
		if (course != null) {
			return Response.ok(course.getIdC()).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

}
