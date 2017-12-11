package co.simplon.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import co.simplon.modele.Course;
import co.simplon.modele.Enseigne;

@Named
public class CourseJpaDao implements CourseDao {

	@Inject
	private EntityManager entityManager;

	public CourseJpaDao() {
		super();
	}

	@Override
	public Course createCourseForEnseigne(Course course, int idE) {
		entityManager.getTransaction().begin();
		Enseigne enseigne = entityManager.find(Enseigne.class, idE);
		course.setEnseigne(enseigne);
		entityManager.persist(course);
		entityManager.getTransaction().commit();
		return course;
	}

}
