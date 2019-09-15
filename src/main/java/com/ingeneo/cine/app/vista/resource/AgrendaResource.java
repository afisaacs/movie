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

import com.ingeneo.cine.app.modelo.entidad.Agenda;
import com.ingeneo.cine.app.negocio.servicio.AgendaService;
import com.ingeneo.cine.app.vista.vo.AgendaVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/agenda")
@Api(tags = "Agenda")
public class AgrendaResource {
	
	@Autowired
	private AgendaService agendaSvc;
	
	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Buscar agenda", notes = "Servicio para buscar agenda")
	public ResponseEntity<Agenda> buscar(@PathVariable Long id) {
		Agenda agenda = agendaSvc.buscar(id);
		if(agenda == null) {
			return new ResponseEntity<Agenda>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Agenda>(agenda, HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	@ApiOperation(value = "Listar agendas", notes = "Servicio para listar agendas")
	public ResponseEntity<List<Agenda>> consultar() {
		return new ResponseEntity<List<Agenda>>(agendaSvc.cosultar(), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ApiOperation(value = "Crear agenda", notes = "Servicio para crear agenda")
	public ResponseEntity<Agenda> crear(@Valid() @RequestBody AgendaVO agendaVo) {
		return new ResponseEntity<Agenda>(agendaSvc.crear(agendaVo), HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{id}")
	@ApiOperation(value = "Editar agenda", notes = "Servicio para editar agenda")
	public ResponseEntity<Agenda> crear(@PathVariable Long id, @RequestBody Agenda agenda) {
		if(agendaSvc.buscar(id) == null) {
			return new ResponseEntity<Agenda>(HttpStatus.NOT_FOUND);
		}
		agenda.setId(id);
		return new ResponseEntity<Agenda>(agendaSvc.actualizar(agenda), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ApiOperation(value = "Eliminar agenda", notes = "Servicio para eliminar agenda")
	public void eliminar(@PathVariable Long id) {
		if(agendaSvc.buscar(id) != null) {
			agendaSvc.eliminar(id);
		}
	}
	
}
