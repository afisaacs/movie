package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.ValorAtributoPelicula;
import com.ingeneo.cine.app.negocio.repositorio.ValorAtributoPeliculaRepository;

@Service
@Transactional(readOnly = true)
public class ValorAtributoPeliculaService {
	
	@Autowired
	private ValorAtributoPeliculaRepository valorAtributoRepository;
	
	public ValorAtributoPelicula buscar(Long id) {
		return valorAtributoRepository.findById(id).orElse(null);
	}
	
	public List<ValorAtributoPelicula> cosultar() {
		return valorAtributoRepository.findAll();
	}
	
	@Transactional
	public ValorAtributoPelicula crear(ValorAtributoPelicula valorAtributo) {
		return this.valorAtributoRepository.save(valorAtributo);
	}
	
	@Transactional
	public ValorAtributoPelicula actualizar(ValorAtributoPelicula valorAtributo) {
		this.valorAtributoRepository.save(valorAtributo);
		return buscar(valorAtributo.getId());
	}
	
	@Transactional
	public void eliminar(Long id) {
		this.valorAtributoRepository.deleteById(id);
	}

}
