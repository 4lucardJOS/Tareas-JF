package com.tarea.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarea.model.Vendedor;

public interface IVendedorRepo extends JpaRepository<Vendedor, Integer>{

}
