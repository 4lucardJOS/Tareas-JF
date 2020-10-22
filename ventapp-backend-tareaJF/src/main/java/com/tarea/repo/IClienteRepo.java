package com.tarea.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarea.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer>{

}
