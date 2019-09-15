package com.ingeneo.cine.app.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "genero")
@Data
public class Genero implements Serializable {
	private static final long serialVersionUID = -7952029586978583901L;

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
	@NotNull
	private String nombre;

}
