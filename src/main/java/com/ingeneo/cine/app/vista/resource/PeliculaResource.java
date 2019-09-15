package com.ingeneo.cine.app.vista.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.cine.app.modelo.entidad.Pelicula;
import com.ingeneo.cine.app.negocio.servicio.PeliculaService;
import com.ingeneo.cine.app.vista.vo.PeliculaREQ;
import com.ingeneo.cine.app.vista.vo.PeliculaRES;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/pelicula")
@Api(tags = "Pelicula")
public class PeliculaResource {
	
	@Autowired
	private PeliculaService peliculaSvc;
	
	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Buscar pelicula", notes = "Servicio para buscar pelicula")
	public ResponseEntity<Pelicula> buscar(@PathVariable Long id) {
		Pelicula pelicula = peliculaSvc.buscar(id);
		if(pelicula == null) {
			return new ResponseEntity<Pelicula>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pelicula>(pelicula, HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	@ApiOperation(value = "Listar peliculas", notes = "Servicio para listar peliculas")
	public ResponseEntity<List<Pelicula>> consultar() {
		return new ResponseEntity<List<Pelicula>>(peliculaSvc.cosultar(), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ApiOperation(value = "Crear pelicula", notes = "Servicio para crear pelicula")
	public ResponseEntity<PeliculaRES> crear(@Valid() @RequestBody PeliculaREQ peliculaVo) {
		Pelicula pelicula = new Pelicula();
		pelicula.setNombreOriginal(peliculaVo.getNombreOriginal());
		pelicula.setNombreTraducido(peliculaVo.getNombreTraducido());
		pelicula.setFechaEstreno(peliculaVo.getFechaEstreno());
		pelicula.setFechaBaja(peliculaVo.getFechaBaja());
		pelicula.setSinopsis(peliculaVo.getSinipsis());
		pelicula.setDuration(peliculaVo.getDuration());
		return new ResponseEntity<PeliculaRES>(peliculaSvc.crear(pelicula, peliculaVo), HttpStatus.CREATED);
	}
	
}
