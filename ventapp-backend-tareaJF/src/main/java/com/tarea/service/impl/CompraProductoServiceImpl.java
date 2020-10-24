package com.tarea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.CompraProducto;
import com.tarea.repo.ICompraProductoRepo;
import com.tarea.service.ICompraProductoService;


@Service
public class CompraProductoServiceImpl implements ICompraProductoService{
	
	@Autowired
	private ICompraProductoRepo repo;
	
	@Override
	public List<CompraProducto> listarProductosPorVenta(Integer idventa){
		return repo.listarProductosPorVenta(idventa);
	}

}
