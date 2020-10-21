package com.tarea.dto;

import org.springframework.hateoas.ResourceSupport;

import com.tarea.model.Cliente;
import com.tarea.model.Vendedor;

public class VentaDTO extends ResourceSupport {
	
	private Integer idVenta;
	private Vendedor vendedor;
	private Cliente cliente;
	
	public Integer getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	

}
