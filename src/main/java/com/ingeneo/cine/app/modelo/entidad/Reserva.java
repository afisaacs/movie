package com.ingeneo.cine.app.modelo.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.ingeneo.cine.app.modelo.enums.EstadoReserva;

import lombok.Data;

@Entity
@Data
public class Reserva implements Serializable {
	private static final long serialVersionUID = -790954310445229906L;
	
	public Reserva () {
		boletas = new ArrayList<Boleta>();
	}
	
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
	
	@Enumerated
	@Column(length = 10)
	private EstadoReserva estado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@NotNull
	private Agenda agenda;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "reserva")
//	@JoinColumn(name = "reserva_id")
	private List<Boleta> boletas;
	
	public void addBoleta(Boleta boleta) {
		boletas.add(boleta);
	}

}
