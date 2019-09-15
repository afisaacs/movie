package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.Usuario;
import com.ingeneo.cine.app.negocio.repositorio.UsuarioRepository;

@Service
@Transactional(readOnly = true)
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario buscar(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public List<Usuario> cosultar() {
		return usuarioRepository.findAll();
	}
	
	@Transactional
	public Usuario crear(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	@Transactional
	public Usuario actualizar(Usuario usuario) {
		this.usuarioRepository.save(usuario);
		return buscar(usuario.getId());
	}
	
	@Transactional
	public void eliminar(Long id) {
		this.usuarioRepository.deleteById(id);
	}

}
