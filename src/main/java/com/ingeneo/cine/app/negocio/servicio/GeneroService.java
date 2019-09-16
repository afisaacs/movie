package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.Genero;
import com.ingeneo.cine.app.negocio.repositorio.GeneroRepository;

@Service
@Transactional(readOnly = true)
public class GeneroService {
	
	@Autowired
	private GeneroRepository generoRepository;
	
	public Genero buscar(Long id) {
		return generoRepository.findById(id).orElse(null);
	}
	
	public List<Genero> cosultar() {
		return generoRepository.findAll();
	}
	
	@Transactional
	public Genero crear(Genero genero) {
		return this.generoRepository.save(genero);
	}
	
	@Transactional
	public Genero actualizar(Genero genero) {
		this.generoRepository.save(genero);
		return buscar(genero.getId());
	}
	
	@Transactional
	public void eliminar(Long id) {
		this.generoRepository.deleteById(id);
	}

}
