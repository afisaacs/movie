package com.ingeneo.cine.app.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "sala")
@Data
public class Sala implements Serializable {

	private static final long serialVersionUID = -8127070522691927793L;
	
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
	
	@Column
	@NotNull
	private Integer filas;
	
	@Column
	@NotNull
	private Integer sillas;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Sucursal sucursal;

	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull
	private Formato formato;
	
}
