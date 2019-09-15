package com.ingeneo.cine.app.vista.resource;

import java.util.List;

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

import com.ingeneo.cine.app.modelo.entidad.Sucursal;
import com.ingeneo.cine.app.modelo.entidad.Sala;
import com.ingeneo.cine.app.modelo.entidad.Formato;
import com.ingeneo.cine.app.negocio.servicio.SucursalService;
import com.ingeneo.cine.app.negocio.servicio.SalaService;
import com.ingeneo.cine.app.negocio.servicio.FormatoService;
import com.ingeneo.cine.app.vista.vo.SalaVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/sala")
@Api(tags = "Sala")
public class SalaResource {
	
	@Autowired
	private SalaService salaSvc;
	
	@Autowired
	private FormatoService formatoSvc;
	
	@Autowired
	private SucursalService sucursalSvc;
	
	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Buscar sala", notes = "Servicio para buscar sala")
	public ResponseEntity<Sala> buscar(@PathVariable Long id) {
		Sala sala = salaSvc.buscar(id);
		if(sala == null) {
			return new ResponseEntity<Sala>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Sala>(sala, HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	@ApiOperation(value = "Listar salas", notes = "Servicio para listar salas")
	public ResponseEntity<List<Sala>> consultar() {
		List<Sala> salas = salaSvc.cosultar();
		return new ResponseEntity<List<Sala>>(salas, HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ApiOperation(value = "Crear sala", notes = "Servicio para crear sala")
	public ResponseEntity<Sala> crear(@RequestBody(required = true) SalaVO salaVo) {
		return guardarSala(salaVo, null);
	}
	
	@PutMapping("/editar/{id}")
	@ApiOperation(value = "Editar sala", notes = "Servicio para editar sala")
	public ResponseEntity<Sala> crear(@PathVariable Long id, @RequestBody SalaVO salaVo) {
		return guardarSala(salaVo, id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ApiOperation(value = "Eliminar sala", notes = "Servicio para eliminar sala")
	public void eliminar(@PathVariable Long id) {
		if(salaSvc.buscar(id) != null) {
			salaSvc.eliminar(id);
		}
	}
	
	public ResponseEntity<Sala> guardarSala(SalaVO salaVo, Long id) {
		boolean esSolicitudInvalida = salaVo.getIdFormato() == null || salaVo.getIdSucursal() == null;
		boolean crear = id == null;
		Sala sala = crear ? new Sala() : salaSvc.buscar(id);
		if(sala == null) {
			return new ResponseEntity<Sala>(HttpStatus.NOT_FOUND);
		}
		if(esSolicitudInvalida) {
			return new ResponseEntity<Sala>(HttpStatus.BAD_REQUEST);
		}
		Formato formato = formatoSvc.buscar(salaVo.getIdFormato());
		Sucursal sucursal = sucursalSvc.buscar(salaVo.getIdSucursal());
		if(formato == null || sucursal == null) {
			return new ResponseEntity<Sala>(HttpStatus.BAD_REQUEST);
		}
		sala.setFormato(formato);
		sala.setSucursal(sucursal);
		sala.setFilas(salaVo.getFilas());
		sala.setSillas(salaVo.getSillas());
		if(crear) {
			return new ResponseEntity<Sala>(salaSvc.actualizar(sala), HttpStatus.OK);
		} else {
			return new ResponseEntity<Sala>(salaSvc.crear(sala), HttpStatus.CREATED);
		}
	}
	
}
