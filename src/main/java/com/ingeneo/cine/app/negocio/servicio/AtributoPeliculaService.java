package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.AtributoPelicula;
import com.ingeneo.cine.app.negocio.repositorio.AtributoPeliculaRepository;

@Service
@Transactional(readOnly = true)
public class AtributoPeliculaService {
	
	@Autowired
	private AtributoPeliculaRepository atributoRepository;
	
	public AtributoPelicula buscar(Long id) {
		return atributoRepository.findById(id).orElse(null);
	}
	
	public List<AtributoPelicula> cosultar() {
		return atributoRepository.findAll();
	}
	
	@Transactional
	public AtributoPelicula crear(AtributoPelicula atributo) {
		return this.atributoRepository.save(atributo);
	}
	
	@Transactional
	public AtributoPelicula actualizar(AtributoPelicula atributo) {
		this.atributoRepository.save(atributo);
		return buscar(atributo.getId());
	}
	
	@Transactional
	public void eliminar(Long id) {
		this.atributoRepository.deleteById(id);
	}

}
