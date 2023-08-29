package com.nasa.prueba.aspirante.infraestructura.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaInterfaz;

@RestController
@RequestMapping("/busqueda")
public class PruebaRestController {
	
	@Autowired
	private PruebaInterfaz pruebaEntityRepository;
	
	@GetMapping("/all")
	public List<PruebaEntity> listAll() {
		return pruebaEntityRepository.findAll();
	}

}
