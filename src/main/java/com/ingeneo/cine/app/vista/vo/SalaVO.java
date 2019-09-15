package com.ingeneo.cine.app.vista.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class SalaVO implements Serializable {
	private static final long serialVersionUID = 5310599495169116623L;
	
	private Integer filas;
	private Integer sillas;
	private Long idSucursal;
	private Long idFormato;

}
