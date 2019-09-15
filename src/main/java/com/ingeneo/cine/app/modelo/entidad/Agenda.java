package com.ingeneo.cine.app.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Agenda implements Serializable {

	private static final long serialVersionUID = -2506451354453828569L;
	
	@PrePersist
	public void prePersist() {
		this.registro = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date registro;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@NotNull
	private Sala sala;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@NotNull
	private Pelicula pelicula;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date fecha;
	
}
