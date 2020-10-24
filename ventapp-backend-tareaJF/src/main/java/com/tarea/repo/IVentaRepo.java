package com.tarea.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tarea.model.Venta;

//@Repository
public interface IVentaRepo extends JpaRepository<Venta, Integer>{
	
	@Query("from Venta v where v.cliente.dni =:dni or LOWER(v.cliente.nombres) like %:nombreCompleto% or LOWER(v.cliente.apellidos) like %:nombreCompleto%")
	List<Venta> buscar(@Param("dni")String dni, @Param("nombreCompleto") String nombreCompleto);
	
	
	@Query("from Venta v where v.fecha between :fechaVenta and :fechaSgte")
	List<Venta> buscarFecha(@Param("fechaVenta") LocalDateTime fechaVenta, @Param("fechaSgte") LocalDateTime fechaSgte);
	
	
	//@Query(value = "select * from fn_listarResumen()", nativeQuery = true)
	//List<Object[]> listarResumen();
	

}
