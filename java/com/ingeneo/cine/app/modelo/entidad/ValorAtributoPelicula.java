package com.ingeneo.cine.app.modelo.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
public class ValorAtributoPelicula implements Serializable {
	private static final long serialVersionUID = 2439226349787306875L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Pelicula pelicula;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private AtributoPelicula atributo;
	
	@NotNull
	private String valor;
	
}
