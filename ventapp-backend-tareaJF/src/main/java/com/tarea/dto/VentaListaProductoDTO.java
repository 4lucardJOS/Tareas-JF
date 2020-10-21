package com.tarea.dto;

import java.util.List;

import com.tarea.model.Producto;
import com.tarea.model.Venta;

public class VentaListaProductoDTO {
	
	private Venta venta;
	private List<Producto> lstProducto;
	
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public List<Producto> getLstProducto() {
		return lstProducto;
	}
	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}
	
	

	

}
