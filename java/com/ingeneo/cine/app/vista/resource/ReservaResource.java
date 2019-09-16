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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.cine.app.modelo.entidad.Reserva;
import com.ingeneo.cine.app.negocio.servicio.ReservaService;
import com.ingeneo.cine.app.vista.vo.ReservaVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/reserva")
@Api(tags = "Reserva")
public class ReservaResource {
	
	@Autowired
	private ReservaService reservaSvc;
	
	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Buscar reserva", notes = "Servicio para buscar reserva")
	public ResponseEntity<Reserva> buscar(@PathVariable Long id) {
		Reserva reserva = reservaSvc.buscar(id);
		if(reserva == null) {
			return new ResponseEntity<Reserva>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Reserva>(reserva, HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	@ApiOperation(value = "Listar reservas", notes = "Servicio para listar reservas")
	public ResponseEntity<List<Reserva>> consultar() {
		return new ResponseEntity<List<Reserva>>(reservaSvc.cosultar(), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ApiOperation(value = "Crear reserva", notes = "Servicio para crear reserva")
	public ResponseEntity<Reserva> crear(@Valid() @RequestBody ReservaVO reservaVo) {
		return new ResponseEntity<Reserva>(reservaSvc.crear(reservaVo), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ApiOperation(value = "Eliminar reserva", notes = "Servicio para eliminar reserva")
	public void eliminar(@PathVariable Long id) {
		if(reservaSvc.buscar(id) != null) {
			reservaSvc.eliminar(id);
		}
	}
	
}
