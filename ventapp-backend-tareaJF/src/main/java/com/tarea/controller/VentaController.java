package com.tarea.controller;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tarea.dto.FiltroVentaDTO;
import com.tarea.dto.VentaDTO;
import com.tarea.dto.VentaListaProductoDTO;
import com.tarea.exception.ModeloNotFoundException;
import com.tarea.model.Archivo;
import com.tarea.model.Venta;
import com.tarea.service.IArchivoService;
import com.tarea.service.IVentaService;


@RestController
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
	private IVentaService service;
	
	@Autowired
	private IArchivoService serviceArchivo;
	
	@GetMapping
	public ResponseEntity<List<Venta>> listar(){
		 List<Venta> lista = service.listar();
		return new ResponseEntity<List<Venta>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Venta> listarPorId(@PathVariable("id") Integer id){
		Venta obj = service.leerPorId(id);
		if(obj.getIdVenta() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Venta>(obj, HttpStatus.OK); 
	}
	
	@GetMapping(value = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VentaDTO> listarHateoas() {
		List<Venta> ventas = new ArrayList<>();
		List<VentaDTO> ventasDTO = new ArrayList<>();
		ventas = service.listar();
		
		for (Venta c : ventas) {
			VentaDTO d = new VentaDTO();
			d.setIdVenta(c.getIdVenta());
			d.setVendedor(c.getVendedor());
			d.setCliente(c.getCliente());
			
			
			ControllerLinkBuilder linkTo = linkTo(methodOn(VentaController.class).listarPorId((c.getIdVenta())));
			d.add(linkTo.withSelfRel());
			ventasDTO.add(d);
			
			ControllerLinkBuilder linkTo1 = linkTo(methodOn(ClienteController.class).listarPorId((c.getCliente().getIdCliente())));
			d.add(linkTo1.withSelfRel());
			ventasDTO.add(d);
			
			ControllerLinkBuilder linkTo2 = linkTo(methodOn(VendedorController.class).listarPorId((c.getVendedor().getIdVendedor())));
			d.add(linkTo2.withSelfRel());		
			ventasDTO.add(d);
		}
		return ventasDTO;
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody VentaListaProductoDTO ventaDTO) {
		Venta obj = service.registrarTransaccional(ventaDTO);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Venta> modificar(@Valid @RequestBody Venta venta) {
		Venta obj = service.modificar(venta);
		return new ResponseEntity<Venta>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Venta obj = service.leerPorId(id);
		if(obj.getIdVenta() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@PostMapping("/buscar")
	public ResponseEntity<List<Venta>> buscar(@RequestBody FiltroVentaDTO filtro) {
		List<Venta> ventas = new ArrayList<>();

		if (filtro != null) {
			if (filtro.getFechaVenta() != null) {
				ventas = service.buscarFecha(filtro);
			} else {
				ventas = service.buscar(filtro);
			}
		}
		return new ResponseEntity<List<Venta>>(ventas, HttpStatus.OK);
	}
	

	
	@PostMapping(value = "/guardarArchivo", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> guardarArchivo(@RequestParam("adjunto") MultipartFile file) throws IOException{
		int rpta = 0;
		Archivo ar = new Archivo();
		ar.setFiletype(file.getContentType());
		ar.setFilename(file.getName());
		ar.setValue(file.getBytes());
		
		rpta = serviceArchivo.guardar(ar);

		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);	
	}
	
	@GetMapping(value = "/leerArchivo/{idArchivo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> leerArchivo(@PathVariable("idArchivo") Integer idArchivo) throws IOException {
				
		byte[] arr = serviceArchivo.leerArchivo(idArchivo); 

		return new ResponseEntity<byte[]>(arr, HttpStatus.OK);
	}

}
