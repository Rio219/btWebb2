package com.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name="presio")
	private BigDecimal presio;
	@ManyToOne
	private Categoria categoria;
	@Column(name="fecha")
	private LocalDate fecha = LocalDate.now();
	
	public Producto() {
		
	}
	
	public Producto(String nombre, String descripcion, BigDecimal presio, Categoria categoria, LocalDate fecha) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.presio = presio;
		this.categoria = categoria;
		this.fecha = fecha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecio() {
		return presio;
	}
	public void setPrecio(BigDecimal precio) {
		this.presio = precio;
	}
	
}
