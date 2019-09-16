package com.ingeneo.cine.app.modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Entity
@Data
public class Catalogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull
	private Sucursal sucursal;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@NotNull
	private Pelicula pelicula;
	
}
