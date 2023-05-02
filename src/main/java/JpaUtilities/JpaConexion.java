package JpaUtilities;



import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class JpaConexion {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
	
	public EntityManagerFactory GetConexion() {
		return this.factory;
	} 
}
