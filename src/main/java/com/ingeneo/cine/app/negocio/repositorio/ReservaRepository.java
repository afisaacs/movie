package com.ingeneo.cine.app.negocio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingeneo.cine.app.modelo.entidad.Agenda;
import com.ingeneo.cine.app.modelo.entidad.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	public List<Reserva> findByAgenda(Agenda agenda);
	
}
