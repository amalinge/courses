package co.simplon.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import co.simplon.modele.Achat;
import co.simplon.modele.Course;
import co.simplon.modele.Produit;

@Named
public class AchatJpaDao implements AchatDao {

	@Inject
	private EntityManager entityManager;

	public AchatJpaDao() {
		super();
	}

	@Override
	public Achat createAchatForCourse(Achat achat, int idC, int idP) {
		entityManager.getTransaction().begin();
		Course course = entityManager.find(Course.class, idC);
		achat.setCourse(course);
		Produit produit = entityManager.find(Produit.class, idP);
		achat.setProduit(produit);
		entityManager.persist(achat);
		entityManager.getTransaction().commit();
		return achat;
	}

}
