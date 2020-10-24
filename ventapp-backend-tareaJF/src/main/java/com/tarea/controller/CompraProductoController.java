package com.tarea.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarea.model.CompraProducto;
import com.tarea.service.ICompraProductoService;

@RestController
@RequestMapping("/compraproductos")
public class CompraProductoController {
	
	@Autowired
	private ICompraProductoService service;
	
	@GetMapping(value = "/{idVenta}")
	public ResponseEntity<List<CompraProducto>> listar(@PathVariable("idVenta") Integer idventa) {
		List<CompraProducto> compraproducto = new ArrayList<>();
		compraproducto = service.listarProductosPorVenta(idventa);
		return new ResponseEntity<List<CompraProducto>>(compraproducto, HttpStatus.OK);
	}

}
