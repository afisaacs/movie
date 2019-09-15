package com.ingeneo.cine.app.vista.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.cine.app.modelo.entidad.Usuario;
import com.ingeneo.cine.app.negocio.servicio.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/usuario")
@Api(tags = "Usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioSvc;
	
	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Buscar usuario", notes = "Servicio para buscar usuario")
	public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
		Usuario usuario = usuarioSvc.buscar(id);
		if(usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	@ApiOperation(value = "Listar usuarios", notes = "Servicio para listar usuarios")
	public ResponseEntity<List<Usuario>> consultar() {
		return new ResponseEntity<List<Usuario>>(usuarioSvc.cosultar(), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ApiOperation(value = "Crear usuario", notes = "Servicio para crear usuario")
	public ResponseEntity<Usuario> crear(@Valid() @RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(usuarioSvc.crear(usuario), HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{id}")
	@ApiOperation(value = "Editar usuario", notes = "Servicio para editar usuario")
	public ResponseEntity<Usuario> crear(@PathVariable Long id, @RequestBody Usuario usuario) {
		if(usuarioSvc.buscar(id) == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		usuario.setId(id);
		return new ResponseEntity<Usuario>(usuarioSvc.actualizar(usuario), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ApiOperation(value = "Eliminar usuario", notes = "Servicio para eliminar usuario")
	public void eliminar(@PathVariable Long id) {
		if(usuarioSvc.buscar(id) != null) {
			usuarioSvc.eliminar(id);
		}
	}
	
}
