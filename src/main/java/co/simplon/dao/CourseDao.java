package co.simplon.dao;

import co.simplon.modele.Course;

public interface CourseDao {
	
	Course createCourseForEnseigne (Course course, int idE);

}
