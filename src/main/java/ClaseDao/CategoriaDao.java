package ClaseDao;

import javax.persistence.EntityManager;

import com.tienda.modelo.Categoria;

public class CategoriaDao {

	private EntityManager em;
	
	
	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	public void guardarDatos(Categoria categoria) {
		em.persist(categoria);
	}

}
