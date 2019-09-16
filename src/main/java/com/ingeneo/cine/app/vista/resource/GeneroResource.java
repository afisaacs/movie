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

import com.ingeneo.cine.app.modelo.entidad.Genero;
import com.ingeneo.cine.app.negocio.servicio.GeneroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/genero")
@Api(tags = "Genero")
public class GeneroResource {
	
	@Autowired
	private GeneroService generoSvc;
	
	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Buscar genero", notes = "Servicio para buscar genero")
	public ResponseEntity<Genero> buscar(@PathVariable Long id) {
		Genero genero = generoSvc.buscar(id);
		if(genero == null) {
			return new ResponseEntity<Genero>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Genero>(genero, HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	@ApiOperation(value = "Listar generos", notes = "Servicio para listar generos")
	public ResponseEntity<List<Genero>> consultar() {
		return new ResponseEntity<List<Genero>>(generoSvc.cosultar(), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ApiOperation(value = "Crear genero", notes = "Servicio para crear genero")
	public ResponseEntity<Genero> crear(@Valid() @RequestBody Genero genero) {
		return new ResponseEntity<Genero>(generoSvc.crear(genero), HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{id}")
	@ApiOperation(value = "Editar genero", notes = "Servicio para editar genero")
	public ResponseEntity<Genero> crear(@PathVariable Long id, @RequestBody Genero genero) {
		if(generoSvc.buscar(id) == null) {
			return new ResponseEntity<Genero>(HttpStatus.NOT_FOUND);
		}
		genero.setId(id);
		return new ResponseEntity<Genero>(generoSvc.actualizar(genero), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ApiOperation(value = "Eliminar genero", notes = "Servicio para eliminar genero")
	public void eliminar(@PathVariable Long id) {
		if(generoSvc.buscar(id) != null) {
			generoSvc.eliminar(id);
		}
	}
	
}
