package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.Agenda;
import com.ingeneo.cine.app.modelo.entidad.Boleta;
import com.ingeneo.cine.app.modelo.entidad.Reserva;
import com.ingeneo.cine.app.negocio.repositorio.AgendaRepository;
import com.ingeneo.cine.app.negocio.repositorio.BoletaRepository;
import com.ingeneo.cine.app.negocio.repositorio.ReservaRepository;
import com.ingeneo.cine.app.vista.vo.ReservaVO;

@Service
@Transactional(readOnly = true)
public class ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Autowired
	private BoletaRepository boletaRepository;
	
	public Reserva buscar(Long id) {
		return reservaRepository.findById(id).orElse(null);
	}
	
	public List<Reserva> cosultar() {
		return reservaRepository.findAll();
	}
	
	public List<Reserva> cosultarSucursal(Long idAgenda) {
		return reservaRepository.findByAgenda(agendaRepository.findById(idAgenda).orElse(null));
	}
	
	@Transactional
	public Reserva crear(ReservaVO reservaVo) {
		Agenda agenda = agendaRepository.findById(reservaVo.getAgenda()).orElse(null);
		Reserva reserva = new Reserva();
		reserva.setAgenda(agenda);
		reserva.setEstado(reservaVo.getEstado());
		Reserva reservaCreada = reservaRepository.save(reserva);
		
		List<Boleta> boletas = reservaVo.getBoletas().stream().map( boletaItem -> {
			Boleta boleta = new Boleta();
			boleta.setFila(boletaItem.getFila());
			boleta.setColumna(boletaItem.getColumna());
			boleta.setReserva(reservaCreada);
			return boletaRepository.save(boleta);
		}).collect(Collectors.toList());
		
		reserva.setBoletas(boletas);
		return this.reservaRepository.save(reserva); 
	}
	
	@Transactional
	public Reserva actualizar(Reserva reserva) {
		this.reservaRepository.save(reserva);
		return buscar(reserva.getId());
	}
	
	@Transactional
	public void eliminar(Long id) {
		this.reservaRepository.deleteById(id);
	}

}
