package com.tarea.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tarea.model.Cliente;

public interface IClienteService extends ICRUD<Cliente>{
	
	Page<Cliente> listarPageable(Pageable pageable);

}
