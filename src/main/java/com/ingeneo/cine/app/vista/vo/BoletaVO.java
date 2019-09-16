package com.ingeneo.cine.app.vista.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BoletaVO {

	@NotNull
	@Min(1)
	private Integer fila;
	
	@NotNull
	@Min(1)
	private Integer columna;
	
}
