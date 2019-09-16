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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "sucursal")
@Data
public class Sucursal implements Serializable {
	
	private static final long serialVersionUID = -1624870129323622899L;
	
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
	
	@Column(length = 50)
	@NotEmpty
	private String nombre;
	
	@Column(length = 100)
	@NotEmpty
	private String direccion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull
	private Usuario administrador;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull
	private Ciudad ciudad;
	
}
