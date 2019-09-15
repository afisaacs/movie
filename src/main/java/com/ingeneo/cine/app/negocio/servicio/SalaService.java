package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.Sala;
import com.ingeneo.cine.app.modelo.entidad.Sucursal;
import com.ingeneo.cine.app.negocio.repositorio.SalaRepository;
import com.ingeneo.cine.app.negocio.repositorio.SucursalRepository;

@Service
@Transactional(readOnly = true)
public class SalaService {
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private SucursalRepository sucursalRepository;
	
	public Sala buscar(Long id) {
		return salaRepository.findById(id).orElse(null);
	}
	
	public List<Sala> cosultar() {
		return salaRepository.findAll();
	}
	
	@Transactional
	public Sala crear(Sala sala) {
		return this.salaRepository.save(sala);
	}
	
	@Transactional
	public Sala actualizar(Sala sala) {
		this.salaRepository.save(sala);
		return buscar(sala.getId());
	}
	
	@Transactional
	public void eliminar(Long id) {
		this.salaRepository.deleteById(id);
	}
	
	public Sucursal findSucursalById(Long id) {
		return sucursalRepository.findById(id).orElse(null);
	}

}
