package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.Formato;
import com.ingeneo.cine.app.negocio.repositorio.FormatoRepository;

@Service
@Transactional(readOnly = true)
public class FormatoService {
	
	@Autowired
	private FormatoRepository formatoRepository;
	
	public Formato buscar(Long id) {
		return formatoRepository.findById(id).orElse(null);
	}
	
	public List<Formato> cosultar() {
		return formatoRepository.findAll();
	}
	
	@Transactional
	public Formato crear(Formato formato) {
		return this.formatoRepository.save(formato);
	}
	
	@Transactional
	public Formato actualizar(Formato formato) {
		this.formatoRepository.save(formato);
		return buscar(formato.getId());
	}
	
	@Transactional
	public void eliminar(Long id) {
		this.formatoRepository.deleteById(id);
	}

}
