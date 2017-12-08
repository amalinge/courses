package co.simplon.endpoint;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.simplon.modele.Course;

@Path("/courses")
@RequestScoped
public class CourseResource {

	@Inject
	private EntityManager entityManager;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getCourses() {
		List<Course> courses = entityManager.createNamedQuery("Course.findAll", Course.class).getResultList();;
		return courses;
	}
}
