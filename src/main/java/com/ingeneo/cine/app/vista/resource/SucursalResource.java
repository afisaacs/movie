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

import com.ingeneo.cine.app.modelo.entidad.Ciudad;
import com.ingeneo.cine.app.modelo.entidad.Sucursal;
import com.ingeneo.cine.app.modelo.entidad.Usuario;
import com.ingeneo.cine.app.negocio.servicio.CiudadService;
import com.ingeneo.cine.app.negocio.servicio.SucursalService;
import com.ingeneo.cine.app.negocio.servicio.UsuarioService;
import com.ingeneo.cine.app.vista.vo.SucursalVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/sucursal")
@Api(tags = "Sucursal")
public class SucursalResource {
	
	@Autowired
	private SucursalService sucursalSvc;
	
	@Autowired
	private UsuarioService usuarioSvc;
	
	@Autowired
	private CiudadService ciudadSvc;
	
	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Buscar sucursal", notes = "Servicio para buscar sucursal")
	public ResponseEntity<Sucursal> buscar(@PathVariable Long id) {
		Sucursal sucursal = sucursalSvc.buscar(id);
		if(sucursal == null) {
			return new ResponseEntity<Sucursal>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Sucursal>(sucursal, HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	@ApiOperation(value = "Listar sucursals", notes = "Servicio para listar sucursals")
	public ResponseEntity<List<Sucursal>> consultar() {
		return new ResponseEntity<List<Sucursal>>(sucursalSvc.cosultar(), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ApiOperation(value = "Crear sucursal", notes = "Servicio para crear sucursal")
	public ResponseEntity<Sucursal> crear(@RequestBody(required = true) SucursalVO sucursalVo) {
		return guardarSucursal(sucursalVo, null);
	}
	
	@PutMapping("/editar/{id}")
	@ApiOperation(value = "Editar sucursal", notes = "Servicio para editar sucursal")
	public ResponseEntity<Sucursal> crear(@PathVariable Long id, @RequestBody SucursalVO sucursalVo) {
		return guardarSucursal(sucursalVo, id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ApiOperation(value = "Eliminar sucursal", notes = "Servicio para eliminar sucursal")
	public void eliminar(@PathVariable Long id) {
		if(sucursalSvc.buscar(id) != null) {
			sucursalSvc.eliminar(id);
		}
	}
	
	public ResponseEntity<Sucursal> guardarSucursal(SucursalVO sucursalVo, Long id) {
		boolean esSolicitudInvalida = sucursalVo.getIdAdministrador() == null || sucursalVo.getIdCiudad() == null;
		boolean crear = id == null;
		Sucursal sucursal = crear ? new Sucursal() : sucursalSvc.buscar(id);
		if(sucursal == null) {
			return new ResponseEntity<Sucursal>(HttpStatus.NOT_FOUND);
		}
		if(esSolicitudInvalida) {
			return new ResponseEntity<Sucursal>(HttpStatus.BAD_REQUEST);
		}
		Usuario administrador = usuarioSvc.buscar(sucursalVo.getIdAdministrador());
		Ciudad ciudad = ciudadSvc.buscar(sucursalVo.getIdCiudad());
		if(administrador == null || ciudad == null) {
			return new ResponseEntity<Sucursal>(HttpStatus.BAD_REQUEST);
		}
		sucursal.setAdministrador(administrador);
		sucursal.setCiudad(ciudad);
		sucursal.setDireccion(sucursalVo.getDireccion());
		sucursal.setNombre(sucursalVo.getNombre());
		if(crear) {
			return new ResponseEntity<Sucursal>(sucursalSvc.actualizar(sucursal), HttpStatus.OK);
		} else {
			return new ResponseEntity<Sucursal>(sucursalSvc.crear(sucursal), HttpStatus.CREATED);
		}
	}
	
}
