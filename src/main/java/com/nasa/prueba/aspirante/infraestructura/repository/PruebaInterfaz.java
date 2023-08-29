package com.nasa.prueba.aspirante.infraestructura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;

public interface PruebaInterfaz extends JpaRepository<PruebaEntity, Integer>{

	@Query("Select p from PruebaEntity as p order by idSearch desc")
	public List<PruebaEntity> orderByDesc();
}
