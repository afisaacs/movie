package com.ingeneo.cine.app.negocio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingeneo.cine.app.modelo.entidad.Formato;
import com.ingeneo.cine.app.modelo.entidad.Sala;
import com.ingeneo.cine.app.modelo.entidad.Sucursal;

public interface SalaRepository extends JpaRepository<Sala, Long> {
	
	public Sucursal findSucursalById(Long id);
	public List<Sala> findByFormatoAndSucursal(Formato formato, Sucursal sucursal);

}
