package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.Catalogo;
import com.ingeneo.cine.app.negocio.repositorio.CatalogoRepository;

@Service
@Transactional(readOnly = true)
public class CatalogoService {
	
	@Autowired
	private CatalogoRepository catalogoRepository;
	
	public Catalogo buscar(Long id) {
		return catalogoRepository.findById(id).orElse(null);
	}
	
	public List<Catalogo> cosultar() {
		return catalogoRepository.findAll();
	}
	
	@Transactional
	public Catalogo crear(Catalogo catalogo) {
		return this.catalogoRepository.save(catalogo);
	}
	
	@Transactional
	public Catalogo actualizar(Catalogo catalogo) {
		this.catalogoRepository.save(catalogo);
		return buscar(catalogo.getId());
	}
	
	@Transactional
	public void eliminar(Long id) {
		this.catalogoRepository.deleteById(id);
	}

}
