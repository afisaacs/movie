package com.ingeneo.cine.app.vista.vo;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PeliculaREQ {

	@NotEmpty
	private String nombreOriginal;
	
	@NotEmpty
	private String nombreTraducido;
	
	@NotNull
	private Date fechaEstreno;
	
	@NotNull
	private Date fechaBaja;
	
	@NotEmpty
	private String sinipsis;
	
	@NotNull
	private Integer duration;
	
	@NotNull
	private Long formato;
	
	@NotEmpty
	private List<Long> generos;
	
	@NotEmpty
	private List<Long> sucursales;
	
	@NotEmpty
	private List<ValorAtributoPeliculaVO> atributos;
	
}
