package com.ingeneo.cine.app.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Boleta implements Serializable {
	private static final long serialVersionUID = 3648836341397614262L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Integer fila;
	
	@NotNull
	private Integer columna;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Reserva reserva;
}
