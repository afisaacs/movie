package com.ingeneo.cine.app.vista.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class SucursalVO implements Serializable {
	private static final long serialVersionUID = -7882315464963593273L;
	
	private String nombre;
	private String direccion;
	private Long idAdministrador;
	private Long idCiudad;

}
