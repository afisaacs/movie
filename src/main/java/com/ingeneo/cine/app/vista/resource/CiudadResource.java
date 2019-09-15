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

import com.ingeneo.cine.app.modelo.entidad.Ciudad;
import com.ingeneo.cine.app.negocio.servicio.CiudadService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ciudad")
@Api(tags = "Ciudad")
public class CiudadResource {
	
	@Autowired
	private CiudadService ciudadSvc;
	
	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Buscar ciudad", notes = "Servicio para buscar ciudad")
	public ResponseEntity<Ciudad> buscar(@PathVariable Long id) {
		Ciudad ciudad = ciudadSvc.buscar(id);
		if(ciudad == null) {
			return new ResponseEntity<Ciudad>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ciudad>(ciudad, HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	@ApiOperation(value = "Listar ciudads", notes = "Servicio para listar ciudads")
	public ResponseEntity<List<Ciudad>> consultar() {
		return new ResponseEntity<List<Ciudad>>(ciudadSvc.cosultar(), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ApiOperation(value = "Crear ciudad", notes = "Servicio para crear ciudad")
	public ResponseEntity<Ciudad> crear(@Valid() @RequestBody Ciudad ciudad) {
		return new ResponseEntity<Ciudad>(ciudadSvc.crear(ciudad), HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{id}")
	@ApiOperation(value = "Editar ciudad", notes = "Servicio para editar ciudad")
	public ResponseEntity<Ciudad> crear(@PathVariable Long id, @RequestBody Ciudad ciudad) {
		if(ciudadSvc.buscar(id) == null) {
			return new ResponseEntity<Ciudad>(HttpStatus.NOT_FOUND);
		}
		ciudad.setId(id);
		return new ResponseEntity<Ciudad>(ciudadSvc.actualizar(ciudad), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ApiOperation(value = "Eliminar ciudad", notes = "Servicio para eliminar ciudad")
	public void eliminar(@PathVariable Long id) {
		if(ciudadSvc.buscar(id) != null) {
			ciudadSvc.eliminar(id);
		}
	}
	
}
