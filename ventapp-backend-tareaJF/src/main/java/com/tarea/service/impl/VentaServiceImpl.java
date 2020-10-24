package com.tarea.service.impl;


import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tarea.dto.FiltroVentaDTO;
import com.tarea.dto.VentaListaProductoDTO;
import com.tarea.model.Venta;
import com.tarea.repo.IVentaRepo;
import com.tarea.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService  {
	
	    @Autowired
	     private IVentaRepo repo;
	
	
	    @Override
	    public Venta registrar(Venta obj) {
		return repo.save(obj);
	    }
	
		@Override
		public Venta modificar(Venta obj) {		
			return repo.save(obj);
		}

		@Override
		public List<Venta> listar() {
			return repo.findAll();
		}

		@Override
		public Venta leerPorId(Integer id) {
			Optional<Venta> op = repo.findById(id);
			return op.isPresent() ? op.get() : new Venta();
		}

		@Override
		public boolean eliminar(Integer id) {		
			repo.deleteById(id);
			return true;
		}

		@Override
		public List<Venta> buscar(FiltroVentaDTO filtro) {		
			return repo.buscar(filtro.getDni(), filtro.getNombreCompleto());
		}


		@Override
		public List<Venta> buscarFecha(FiltroVentaDTO filtro) {
			LocalDateTime fechaSgte = filtro.getFechaVenta().plusDays(1);
			return repo.buscarFecha(filtro.getFechaVenta(), fechaSgte);
		}

		@Override
		public Venta registrarTransaccional(VentaListaProductoDTO dto) {
			// TODO Auto-generated method stub
			return null;
		}

		
}

		

