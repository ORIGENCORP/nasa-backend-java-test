package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import com.nasa.prueba.aspirante.infraestructura.clientrest.PruebaClienteRest;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaInterfaz;


@Component
@EnableScheduling
public class PruebaTask {
	
	@Autowired
	private PruebaInterfaz pruebaEntityRepository;
	
	Logger logger = LoggerFactory.getLogger(PruebaTask.class);
	
	@Scheduled(fixedDelay = 100000)
	public void verificaPorHora() {
		System.out.println("Consumo programado de API cada 1 minuto - " + System.currentTimeMillis() / 1000);
		PruebaClienteRest nasaRest = new PruebaClienteRest();
		JsonNode items = nasaRest.search("apolo 11");
		if (items.isArray()) {
			int c =0;
			for (JsonNode item : items) {
				PruebaEntity nuevoRegistro = new PruebaEntity();
				nuevoRegistro.setCenter(item.get("data").get(0).get("center").toString());
				nuevoRegistro.setFechaCreacion(new Date());
				nuevoRegistro.setHref(item.get("href").toString());
				nuevoRegistro.setNasaId(item.get("data").get(0).get("nasa_id").toString());
				nuevoRegistro.setTitulo(item.get("data").get(0).get("title").toString());
				pruebaEntityRepository.save(nuevoRegistro);
				c++;
			}
			logger.info("Cantidad de registros obtenidos de api NASA: "+c);
		}else {
			logger.info("Error al consumir api NASA");
		}
	}
}
