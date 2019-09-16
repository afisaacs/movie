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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "ciudad")
@Data
public class Ciudad implements Serializable {
	private static final long serialVersionUID = -9038730000487968781L;
	
	@PrePersist
	public void prePersist() {
		this.registro = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;
	
	@NotEmpty
	@Column(length = 20)
	private String codigo;
	
	@NotEmpty
	@Column(length = 50)
	private String nombre;
	
}
