package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.Agenda;
import com.ingeneo.cine.app.negocio.repositorio.AgendaRepository;

@Service
@Transactional(readOnly = true)
public class AgendaService {
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	public Agenda buscar(Long id) {
		return agendaRepository.findById(id).orElse(null);
	}
	
	public List<Agenda> cosultar() {
		return agendaRepository.findAll();
	}
	
	@Transactional
	public Agenda crear(Agenda agenda) {
		return this.agendaRepository.save(agenda);
	}
	
	@Transactional
	public Agenda actualizar(Agenda agenda) {
		this.agendaRepository.save(agenda);
		return buscar(agenda.getId());
	}
	
	@Transactional
	public void eliminar(Long id) {
		this.agendaRepository.deleteById(id);
	}

}
