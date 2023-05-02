package ClaseDao;
import java.util.List;

import javax.persistence.EntityManager;

import com.tienda.modelo.Producto;

public class ProductoDao {

	private EntityManager em;
	
	
	public ProductoDao(EntityManager em) {
		this.em = em;
	}
	public void guardarDatos(Producto producto) {
		em.persist(producto);
	}
	
	public Producto actualizarDatos(Producto producto) {
		Producto productoActualizado = em.merge(producto);
		return productoActualizado;
	}
	
	public void borrarProducto(Producto producto) {
		em.remove(producto);
	}
	
	public Producto consultaXId(long id) {
		return em.find(Producto.class, id);
	}
	
	public List<Producto> consultaAll(){
		String jpql = "SELECT p FROM Producto AS p";
		List<Producto> listaProductos = em.createQuery(jpql, Producto.class).getResultList();
		return listaProductos;
	}
	
	public List<Producto> consultaPorNombre(String nombre){
        String jpql =" SELECT P FROM Producto AS P WHERE P.nombre=:nombre ";
        return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
    }

    public List<Producto> consultaPorNombreDeCategoria(String nombre){
        String jpql="SELECT p FROM Producto AS p WHERE p.categoria.nombre=:nombre";
        return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
    }

    public String consultarPrecioPorNombreDeProducto(String nombre) {
        String jpql="SELECT p.descripcion FROM Producto AS p WHERE p.nombre=:nombre";
        return em.createQuery(jpql,String.class).setParameter("nombre", nombre).getSingleResult();
    }
	
	

}
