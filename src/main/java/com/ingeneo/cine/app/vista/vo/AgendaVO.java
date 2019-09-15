package com.ingeneo.cine.app.vista.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AgendaVO {

	@NotNull
	private Date fecha;
	
	@NotNull
	private Long sala;
	
	@NotNull
	private Long pelicula;
}
