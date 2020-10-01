package com.tarea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;



@Entity
@Table(name = "supervisor")
public class Supervisor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSupervisor;
	
	@Size(min = 3, message = "Nombres debe tener minimo 3 caracteres.")
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;
	
	@Size(min = 3, message = "Apellidos deben tener minimo 3 caracteres.")
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;
	
	@Size(min = 8, max = 8, message = "DNI debe tener 8 caracteres")
	@Column(name = "dni", nullable = false, length = 8)
	private String dni;
	
	@Size(min = 3, max = 150, message = "Direccion debe tener minimo 3 caracteres.")
	@Column(name = "direccion", nullable = false, length = 150)
	private String direccion;
	
	@Size(min = 3, max = 100, message = "Comuna debe tener minimo 3 caracteres.")
	@Column(name = "comuna", nullable = false, length = 100)
	private String comuna;
	
	@Size(min = 3, max = 100, message = "Ciudad debe tener minimo 3 caracteres.")
	@Column(name = "ciudad", nullable = false, length = 100)
	private String ciudad;

	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefono", nullable = true, length = 9)
	private String telefono;
	
	@Email
	@Column(name = "email", nullable = true, length = 55)
	private String email;

	public Integer getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(Integer idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
