package com.ingeneo.cine.app.vista.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ingeneo.cine.app.modelo.enums.EstadoReserva;

import lombok.Data;

@Data
public class ReservaVO implements Serializable {
	private static final long serialVersionUID = -6975213632004932287L;
	
	@NotNull
	private Long agenda;
	
	@Enumerated
	private EstadoReserva estado;
	
	@Size(max = 5)
	@NotEmpty
	private List<BoletaVO> boletas;
	
}
