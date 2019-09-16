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

import com.ingeneo.cine.app.modelo.entidad.AtributoPelicula;
import com.ingeneo.cine.app.negocio.servicio.AtributoPeliculaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/atributo")
@Api(tags = "Atributo película")
public class AtributoPeliculaResource {
	
	@Autowired
	private AtributoPeliculaService atributoSvc;
	
	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Buscar atributo", notes = "Servicio para buscar atributo")
	public ResponseEntity<AtributoPelicula> buscar(@PathVariable Long id) {
		AtributoPelicula atributo = atributoSvc.buscar(id);
		if(atributo == null) {
			return new ResponseEntity<AtributoPelicula>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AtributoPelicula>(atributo, HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	@ApiOperation(value = "Listar atributos", notes = "Servicio para listar atributos")
	public ResponseEntity<List<AtributoPelicula>> consultar() {
		return new ResponseEntity<List<AtributoPelicula>>(atributoSvc.cosultar(), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ApiOperation(value = "Crear atributo", notes = "Servicio para crear atributo")
	public ResponseEntity<AtributoPelicula> crear(@Valid() @RequestBody AtributoPelicula atributo) {
		return new ResponseEntity<AtributoPelicula>(atributoSvc.crear(atributo), HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{id}")
	@ApiOperation(value = "Editar atributo", notes = "Servicio para editar atributo")
	public ResponseEntity<AtributoPelicula> crear(@PathVariable Long id, @RequestBody AtributoPelicula atributo) {
		if(atributoSvc.buscar(id) == null) {
			return new ResponseEntity<AtributoPelicula>(HttpStatus.NOT_FOUND);
		}
		atributo.setId(id);
		return new ResponseEntity<AtributoPelicula>(atributoSvc.actualizar(atributo), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ApiOperation(value = "Eliminar atributo", notes = "Servicio para eliminar atributo")
	public void eliminar(@PathVariable Long id) {
		if(atributoSvc.buscar(id) != null) {
			atributoSvc.eliminar(id);
		}
	}
	
}
