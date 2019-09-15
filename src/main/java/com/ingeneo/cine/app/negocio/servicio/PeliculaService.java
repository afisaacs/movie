package com.ingeneo.cine.app.negocio.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cine.app.modelo.entidad.AtributoPelicula;
import com.ingeneo.cine.app.modelo.entidad.Catalogo;
import com.ingeneo.cine.app.modelo.entidad.Formato;
import com.ingeneo.cine.app.modelo.entidad.Genero;
import com.ingeneo.cine.app.modelo.entidad.Pelicula;
import com.ingeneo.cine.app.modelo.entidad.Sala;
import com.ingeneo.cine.app.modelo.entidad.Sucursal;
import com.ingeneo.cine.app.modelo.entidad.ValorAtributoPelicula;
import com.ingeneo.cine.app.negocio.repositorio.AtributoPeliculaRepository;
import com.ingeneo.cine.app.negocio.repositorio.CatalogoRepository;
import com.ingeneo.cine.app.negocio.repositorio.FormatoRepository;
import com.ingeneo.cine.app.negocio.repositorio.GeneroRepository;
import com.ingeneo.cine.app.negocio.repositorio.PeliculaRepository;
import com.ingeneo.cine.app.negocio.repositorio.SalaRepository;
import com.ingeneo.cine.app.negocio.repositorio.SucursalRepository;
import com.ingeneo.cine.app.negocio.repositorio.ValorAtributoPeliculaRepository;
import com.ingeneo.cine.app.vista.vo.PeliculaREQ;
import com.ingeneo.cine.app.vista.vo.PeliculaRES;

@Service
@Transactional(readOnly = true)
public class PeliculaService {
	
	@Autowired
	private PeliculaRepository peliculaRepository;
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@Autowired
	private SucursalRepository sucursalRepository;
	
	@Autowired
	private CatalogoRepository catalogoRepository;
	
	@Autowired
	private FormatoRepository formatoRepository;
	
	@Autowired
	private AtributoPeliculaRepository atributoPeliculaRepository;
	
	@Autowired
	private ValorAtributoPeliculaRepository valorAtributoPeliculaRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	public Pelicula buscar(Long id) {
		return peliculaRepository.findById(id).orElse(null);
	}
	
	public List<Pelicula> cosultar() {
		return peliculaRepository.findAll();
	}
	
	public List<Sala> consultarSalas(Long idPelicula, Long idSucursal) {
		Pelicula pelicula = peliculaRepository.findById(idPelicula).orElse(null);
		Sucursal sucursal = sucursalRepository.findById(idSucursal).orElse(null);
		return salaRepository.findByFormatoAndSucursal(pelicula.getFormato(), sucursal);
	}
	
	@Transactional
	public Pelicula crear(Pelicula pelicula) {
		return this.peliculaRepository.save(pelicula);
	}
	
	@Transactional()
	public PeliculaRES crear(Pelicula pelicula, PeliculaREQ peliculaReq) {
		
		List<Genero> generos = peliculaReq.getGeneros().stream().map(generoid -> generoRepository.findById(generoid).orElse(null)).collect(Collectors.toList());
		Formato formato = formatoRepository.findById(peliculaReq.getFormato()).orElse(null);
		pelicula.setGeneros(generos);
		pelicula.setFormato(formato);
		Pelicula peliculaCreada = crear(pelicula);
		
		List<ValorAtributoPelicula> atributos = peliculaReq.getAtributos().stream().map(atributo -> {
			AtributoPelicula atributoPelicula = atributoPeliculaRepository.findById(atributo.getAtributo()).orElse(null);
			ValorAtributoPelicula valorAtributo = new ValorAtributoPelicula();
			valorAtributo.setAtributo(atributoPelicula);
			valorAtributo.setPelicula(peliculaCreada);
			valorAtributo.setValor(atributo.getValor());
			return valorAtributoPeliculaRepository.save(valorAtributo);
		}).collect(Collectors.toList());
		
		List<Sucursal> sucursales = peliculaReq.getSucursales().stream().map(sucursalid -> {
			Sucursal sucursal = sucursalRepository.findById(sucursalid).orElse(null);
			Catalogo catalogo = new Catalogo();
			catalogo.setPelicula(peliculaCreada);
			catalogo.setSucursal(sucursal);
			catalogoRepository.save(catalogo);
			return sucursal;
		}).collect(Collectors.toList());
		
		PeliculaRES peliculaRes = new PeliculaRES();
		
		peliculaRes.setNombreOriginal(peliculaCreada.getNombreOriginal());
		peliculaRes.setNombreTraducido(peliculaReq.getNombreTraducido());
		peliculaRes.setFechaEstreno(peliculaCreada.getFechaEstreno());
		peliculaRes.setFechaBaja(peliculaCreada.getFechaBaja());
		peliculaRes.setSinipsis(peliculaCreada.getSinopsis());
		peliculaRes.setDuration(peliculaCreada.getDuration());
		peliculaRes.setFormato(formato);
		peliculaRes.setGeneros(generos);
		peliculaRes.setSucursales(sucursales);
		peliculaRes.setAtributos(atributos);
		
		return peliculaRes;
	}

}
