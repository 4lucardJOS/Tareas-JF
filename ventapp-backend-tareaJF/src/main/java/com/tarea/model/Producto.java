package com.tarea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	@ManyToOne
	@JoinColumn(name = "id_marca", nullable = false, foreignKey = @ForeignKey(name = "FK_marca_producto"))
	private Marca marca;
	
	@Size(min = 3, message = "Nombre debe tener minimo 3 caracteres.")
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;
	
	@Size(min = 3, message = "Descripcion debe tener minimo 3 caracteres." )
	@Column(name = "descripcion", nullable = false, length = 150)
	private String descripcion;
	
	@PositiveOrZero(message = "ValorProducto debe ser igual o mayor que cero")
	@Column(name = "valorProducto", nullable = false, length = 9)
	private Integer valorproducto;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
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

	public Integer getValorproducto() {
		return valorproducto;
	}

	public void setValorproducto(Integer valorproducto) {
		this.valorproducto = valorproducto;
	}	
}
