package com.tarea.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.Vendedor;
import com.tarea.repo.IVendedorRepo;
import com.tarea.service.IVendedorService;

@Service
public class VendedorServiceImpl implements IVendedorService{
	
	@Autowired
	private IVendedorRepo repo;
	
	@Override
	public Vendedor registrar(Vendedor ven) {
		return repo.save(ven);
	}
	
	@Override
	public Vendedor modificar(Vendedor ven) {
		return repo.save(ven);
	}
	
	@Override
	public List<Vendedor> listar() {
		return repo.findAll();
	}
	
	@Override
	public Vendedor leerPorId(Integer id) {
		Optional<Vendedor> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Vendedor();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
