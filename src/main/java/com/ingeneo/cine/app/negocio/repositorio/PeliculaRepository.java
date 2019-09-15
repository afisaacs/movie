package com.ingeneo.cine.app.negocio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingeneo.cine.app.modelo.entidad.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

}
