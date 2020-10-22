package com.tarea.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarea.model.Archivo;

public interface IArchivoRepo extends JpaRepository<Archivo, Integer>{

}
