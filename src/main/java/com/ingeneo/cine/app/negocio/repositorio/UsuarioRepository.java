package com.ingeneo.cine.app.negocio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingeneo.cine.app.modelo.entidad.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
