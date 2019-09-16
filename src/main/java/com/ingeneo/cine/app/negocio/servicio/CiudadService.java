package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.Ciudad;
import com.ingeneo.cine.app.negocio.repositorio.CiudadRepository;

@Service
@Transactional(readOnly = true)
public class CiudadService {
	
	@Autowired
	private CiudadRepository ciudadRepository;
	
	public Ciudad buscar(Long id) {
		return ciudadRepository.findById(id).orElse(null);
	}
	
	public List<Ciudad> cosultar() {
		return ciudadRepository.findAll();
	}
	
	@Transactional
	public Ciudad crear(Ciudad ciudad) {
		return this.ciudadRepository.save(ciudad);
	}
	
	@Transactional
	public Ciudad actualizar(Ciudad ciudad) {
		this.ciudadRepository.save(ciudad);
		return buscar(ciudad.getId());
	}
	
	@Transactional
	public void eliminar(Long id) {
		this.ciudadRepository.deleteById(id);
	}

}
