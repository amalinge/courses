package co.simplon.dao;

import co.simplon.modele.Achat;

public interface AchatDao {
	
	Achat createAchatForCourse (Achat achat, int idC, int idP);

}
