package com.ingeneo.cine.app.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "pelicula")
@Data
public class Pelicula implements Serializable {
	private static final long serialVersionUID = -5690609287452813316L;

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

	@Column(length = 100)
	@NotNull
	private String nombreOriginal;

	@Column(length = 100)
	@NotNull
	private String nombreTraducido;

	@Temporal(TemporalType.DATE)
	@NotNull
	private Date fechaEstreno;

	@Temporal(TemporalType.DATE)
	@NotNull
	private Date fechaBaja;

	@Column(length = 100)
	private String portada;

	@Column(columnDefinition = "text")
	@NotNull
	private String sinopsis;

	@Column(length = 3)
	@NotNull
	private Integer duration;

	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull
	private Formato formato;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Genero> generos;

}
