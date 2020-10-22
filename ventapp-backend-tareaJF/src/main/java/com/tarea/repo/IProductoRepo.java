package com.tarea.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarea.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer> {

}
