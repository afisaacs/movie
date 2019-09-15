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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.ingeneo.cine.app.modelo.enums.Rol;

import lombok.Data;

@Data
@Table(name = "usuario")
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = -300202883582409876L;
	
	@PrePersist
	public void prePersist() {
		if(this.registro == null) {
			this.registro = new Date();
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date registro;
	
	@NotEmpty
	@Column(length = 100)
	private String nombre;
	
	@NotEmpty
	@Column(length = 100)
	private String apellido;
	
	@Email
	@Column(length = 50)
	private String correo;
	
	@NotEmpty
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Rol rol;
	
}
