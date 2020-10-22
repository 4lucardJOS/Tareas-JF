package com.tarea.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tarea.model.CompraProducto;

public interface ICompraProductoRepo extends JpaRepository<CompraProducto, Integer> {
	
	
	@Modifying
	@Query(value = "INSERT INTO compra_producto(id_venta, id_producto) VALUES (:idVenta, :idProducto)", nativeQuery = true)
	Integer registrar(@Param("idVenta") Integer idVenta, @Param("idProducto") Integer idProducto);
	
	
	@Query("from CompraProducto cp where cp.venta.idVenta = :idVenta")
	List<CompraProducto> listarProductosPorVenta(@Param("idVenta") Integer idventa);

}
