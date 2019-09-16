package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.Agenda;
import com.ingeneo.cine.app.modelo.entidad.Pelicula;
import com.ingeneo.cine.app.modelo.entidad.Sala;
import com.ingeneo.cine.app.negocio.repositorio.AgendaRepository;
import com.ingeneo.cine.app.negocio.repositorio.PeliculaRepository;
import com.ingeneo.cine.app.negocio.repositorio.SalaRepository;
import com.ingeneo.cine.app.vista.vo.AgendaVO;

@Service
@Transactional(readOnly = true)
public class AgendaService {
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private PeliculaRepository peliculaRepository;
	
	public Agenda buscar(Long id) {
		return agendaRepository.findById(id).orElse(null);
	}
	
	public List<Agenda> cosultar() {
		return agendaRepository.findAll();
	}
	
	@Transactional
	public Agenda crear(AgendaVO agendaVo) {
		Pelicula pelicula = peliculaRepository.findById(agendaVo.getPelicula()).orElse(null);
		Sala sala = salaRepository.findById(agendaVo.getSala()).orElse(null);
		Agenda agenda = new Agenda();
		agenda.setFecha(agendaVo.getFecha());
		agenda.setSala(sala);
		agenda.setPelicula(pelicula);
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
