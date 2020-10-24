package com.tarea.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tarea.exception.ModeloNotFoundException;
import com.tarea.model.Vendedor;
import com.tarea.service.IVendedorService;


@RestController
@RequestMapping("/vendedores")
public class VendedorController {

	@Autowired
	private IVendedorService service;
	
	
	@GetMapping
	public ResponseEntity<List<Vendedor>> listar() {
		List<Vendedor> lista = service.listar();
		return new ResponseEntity<List<Vendedor>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vendedor> listarPorId(@PathVariable("id") Integer id) {
		Vendedor obj = service.leerPorId(id);
		if (obj.getIdVendedor() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Vendedor>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Vendedor vendedor) {
		Vendedor obj = service.registrar(vendedor);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vendedor.getIdVendedor()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Vendedor> modificar(@Valid @RequestBody Vendedor vendedor) {
		Vendedor obj = service.modificar(vendedor);
		return new ResponseEntity<Vendedor>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Vendedor obj = service.leerPorId(id);
		if (obj.getIdVendedor() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
