package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.Ciudad;
import com.ingeneo.cine.app.modelo.entidad.Sala;
import com.ingeneo.cine.app.modelo.entidad.Sucursal;
import com.ingeneo.cine.app.modelo.entidad.Usuario;
import com.ingeneo.cine.app.negocio.repositorio.CiudadRepository;
import com.ingeneo.cine.app.negocio.repositorio.SalaRepository;
import com.ingeneo.cine.app.negocio.repositorio.SucursalRepository;
import com.ingeneo.cine.app.negocio.repositorio.UsuarioRepository;

@Service
@Transactional(readOnly = true)
public class SucursalService {
	
	@Autowired
	private SucursalRepository sucursalRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CiudadRepository ciudadRepository;
	
	public Sucursal buscar(Long id) {
		return sucursalRepository.findById(id).orElse(null);
	}
	
	public List<Sucursal> cosultar() {
		return sucursalRepository.findAll();
	}
	
	@Transactional
	public Sucursal crear(Sucursal sucursal) {
		return this.sucursalRepository.save(sucursal);
	}
	
	@Transactional
	public Sucursal actualizar(Sucursal sucursal) {
		this.sucursalRepository.save(sucursal);
		return buscar(sucursal.getId());
	}
	
	@Transactional
	public void eliminar(Long id) {
		this.sucursalRepository.deleteById(id);
	}
	
	public Sala findSalaById(Long id) {
		return salaRepository.findById(id).orElse(null);
	}
	
	public Usuario findAdministradorById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public Ciudad findCiudadById(Long id) {
		return ciudadRepository.findById(id).orElse(null);
	}

}
