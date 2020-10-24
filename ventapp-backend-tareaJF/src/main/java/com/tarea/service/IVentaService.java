package com.tarea.service;

import java.util.List;

import com.tarea.dto.FiltroVentaDTO;
import com.tarea.dto.VentaListaProductoDTO;
import com.tarea.model.Venta;

public interface IVentaService extends ICRUD<Venta>{
	
	Venta registrarTransaccional(VentaListaProductoDTO dto);
	
	List<Venta> buscar(FiltroVentaDTO filtro);
	
	List<Venta> buscarFecha(FiltroVentaDTO filtro);
	
	

}
