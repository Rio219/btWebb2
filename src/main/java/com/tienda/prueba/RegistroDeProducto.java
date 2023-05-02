package com.tienda.prueba;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import com.tienda.modelo.Categoria;
import com.tienda.modelo.Producto;

import ClaseDao.CategoriaDao;
import ClaseDao.ProductoDao;
import JpaUtilities.JpaConexion;

public class RegistroDeProducto {

	public static void main(String[] args) {
	
		Categoria celulares = new Categoria("Celulares");
		Categoria consolas = new Categoria("Consolas");
		Categoria laptop = new Categoria("Laptop");
		Producto xbox = new Producto("xbox series ","series s",new BigDecimal("1200"),consolas, LocalDate.now());
		Producto computador = new Producto("Computador gamer","Acer",new BigDecimal("1000"),laptop, LocalDate.now());
		Producto celular = new Producto("Celular","Samsung",new BigDecimal("600"),celulares, LocalDate.now());
		Producto celularhuawei = new Producto("Celular","huawei",new BigDecimal("800"),celulares, LocalDate.now());
		JpaConexion jpaConexion = new JpaConexion();
		EntityManager em = jpaConexion.GetConexion().createEntityManager();
		ProductoDao productodao = new ProductoDao(em);
		CategoriaDao categoriadao = new CategoriaDao(em);
		em.getTransaction().begin();
		categoriadao.guardarDatos(celulares);
		categoriadao.guardarDatos(consolas);
		categoriadao.guardarDatos(laptop);
		productodao.guardarDatos(celular);
		productodao.guardarDatos(computador);
		productodao.guardarDatos(xbox);
		productodao.guardarDatos(celularhuawei);
		em.flush();
		productodao.actualizarDatos(celularhuawei).setNombre("p9 lite");
		em.flush();
		productodao.borrarProducto(computador);
		em.getTransaction().commit();
		Producto productoid = productodao.consultaXId(xbox.getId());
		System.out.println(productoid.getDescripcion());
		List<Producto> productos = productodao.consultaAll();
		for (Producto producto : productos) {
			System.out.println(producto.getNombre());
		}
		String precio = productodao.consultarPrecioPorNombreDeProducto("Celular");
		System.out.println("El precio es: "+precio);
		em.close();
	}

}
