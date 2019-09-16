package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.Boleta;
import com.ingeneo.cine.app.negocio.repositorio.BoletaRepository;

@Service
@Transactional(readOnly = true)
public class BoletaServicio {
	
	@Autowired
	private BoletaRepository boletaRepository;
	
	public Boleta buscar(Long id) {
		return boletaRepository.findById(id).orElse(null);
	}
	
	public List<Boleta> cosultar() {
		return boletaRepository.findAll();
	}
	
	@Transactional
	public Boleta crear(Boleta boleta) {
		return this.boletaRepository.save(boleta);
	}
	
	@Transactional
	public Boleta actualizar(Boleta boleta) {
		this.boletaRepository.save(boleta);
		return buscar(boleta.getId());
	}
	
	@Transactional
	public void eliminar(Long id) {
		this.boletaRepository.deleteById(id);
	}

}
