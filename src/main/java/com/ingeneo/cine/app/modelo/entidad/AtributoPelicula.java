package com.ingeneo.cine.app.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ingeneo.cine.app.modelo.enums.TipoAtributo;

import lombok.Data;

@Entity
@Data
public class AtributoPelicula implements Serializable {
	private static final long serialVersionUID = 8997742357952781279L;
	
	@PrePersist
	public void prePersist() {
		this.registro = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;
	
	@Column(length = 50)
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	private TipoAtributo tipo;
	
}
