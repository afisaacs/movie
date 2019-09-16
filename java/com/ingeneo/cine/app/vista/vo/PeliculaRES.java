package com.ingeneo.cine.app.vista.vo;

import java.util.Date;
import java.util.List;

import com.ingeneo.cine.app.modelo.entidad.Formato;
import com.ingeneo.cine.app.modelo.entidad.Genero;
import com.ingeneo.cine.app.modelo.entidad.Sucursal;
import com.ingeneo.cine.app.modelo.entidad.ValorAtributoPelicula;

import lombok.Data;

@Data
public class PeliculaRES {
	
	private String nombreOriginal;
	private String nombreTraducido;
	private Date fechaEstreno;
	private Date fechaBaja;
	private String sinipsis;
	private Integer duration;
	private Formato formato;
	private List<Genero> generos;
	private List<Sucursal> sucursales;
	private List<ValorAtributoPelicula> atributos;

}
