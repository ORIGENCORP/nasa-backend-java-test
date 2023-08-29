package com.nasa.prueba.aspirante.infraestructura.clientrest;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PruebaClienteRest {
	
	String uri = "https://images-api.nasa.gov";
	
	Logger logger = LoggerFactory.getLogger(PruebaClienteRest.class);
	
	@Async
	public JsonNode search(String item) {
		ResponseEntity<String> response = null;
		JsonNode items = null;
		try {
			uri = uri.concat("/search?q={item}&page_size={size}");
			logger.info("URL para search: "+uri);
			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("item", item);
			uriVariables.put("size", "30");
			RestTemplate template = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
	        HttpEntity requestEntity = new HttpEntity<>(headers);
			response = template.exchange(uri, HttpMethod.GET, requestEntity, String.class, uriVariables);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(response.getBody());
			items = root.get("collection").get("items");
			return items;
			
		} catch (Exception e) {
			logger.info("Exception on search(): "+e.getMessage());
		}
		return items;
	}

}
