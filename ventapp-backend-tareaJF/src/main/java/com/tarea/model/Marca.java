package com.tarea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "marca")
public class Marca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMarca;
	
	@Size(min = 3, message = "Nombre debe tener minimo 3 caracteres.")
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;
	
	@Size(min = 3, message = "Descripcion debe tener minimo 3 caracteres." )
	@Column(name = "descripcion", nullable = false, length = 150)
	private String descripcion;
	
	@Size(min = 3, max = 150, message = "Direccion debe tener minimo 3 caracteres.")
	@Column(name = "direccion", nullable = false, length = 150)
	private String direccion;
	
	@Size(min = 3, max = 100, message = "Ciudad debe tener minimo 3 caracteres.")
	@Column(name = "ciudad", nullable = false, length = 100)
	private String ciudad;

	public Integer getIdMarca() {
		return idMarca;
	}


	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
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


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
}

