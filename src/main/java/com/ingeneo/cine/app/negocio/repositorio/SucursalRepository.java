package com.ingeneo.cine.app.negocio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingeneo.cine.app.modelo.entidad.Ciudad;
import com.ingeneo.cine.app.modelo.entidad.Sala;
import com.ingeneo.cine.app.modelo.entidad.Sucursal;
import com.ingeneo.cine.app.modelo.entidad.Usuario;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
	
	public Sala findSalaById(Long id);
	public Usuario findAdministradorById(Long id);
	public Ciudad findCiudadById(Long id);
	
}
