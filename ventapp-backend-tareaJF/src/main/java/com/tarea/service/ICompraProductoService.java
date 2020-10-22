package com.tarea.service;

import java.util.List;

import com.tarea.model.CompraProducto;

public interface ICompraProductoService {
	
	List<CompraProducto> listarProductosPorVenta(Integer idVenta);

}
