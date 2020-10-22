package com.tarea.service;

import com.tarea.model.Archivo;

public interface IArchivoService {
	
	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);

}
