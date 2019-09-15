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

import com.ingeneo.cine.app.modelo.entidad.Formato;
import com.ingeneo.cine.app.negocio.servicio.FormatoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/formato")
@Api(tags = "Formato")
public class FormatoResource {
	
	@Autowired
	private FormatoService formatoSvc;
	
	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Buscar formato", notes = "Servicio para buscar formato")
	public ResponseEntity<Formato> buscar(@PathVariable Long id) {
		Formato formato = formatoSvc.buscar(id);
		if(formato == null) {
			return new ResponseEntity<Formato>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Formato>(formato, HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	@ApiOperation(value = "Listar formatos", notes = "Servicio para listar formatos")
	public ResponseEntity<List<Formato>> consultar() {
		return new ResponseEntity<List<Formato>>(formatoSvc.cosultar(), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ApiOperation(value = "Crear formato", notes = "Servicio para crear formato")
	public ResponseEntity<Formato> crear(@Valid() @RequestBody Formato formato) {
		return new ResponseEntity<Formato>(formatoSvc.crear(formato), HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{id}")
	@ApiOperation(value = "Editar formato", notes = "Servicio para editar formato")
	public ResponseEntity<Formato> crear(@PathVariable Long id, @RequestBody Formato formato) {
		if(formatoSvc.buscar(id) == null) {
			return new ResponseEntity<Formato>(HttpStatus.NOT_FOUND);
		}
		formato.setId(id);
		return new ResponseEntity<Formato>(formatoSvc.actualizar(formato), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ApiOperation(value = "Eliminar formato", notes = "Servicio para eliminar formato")
	public void eliminar(@PathVariable Long id) {
		if(formatoSvc.buscar(id) != null) {
			formatoSvc.eliminar(id);
		}
	}
	
}
