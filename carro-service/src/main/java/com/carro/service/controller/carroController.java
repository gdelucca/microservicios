package com.carro.service.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carro.service.entities.carro;
import com.carro.service.services.carroService;


@RestController
@RequestMapping("/carro")

public class carroController {

	@Autowired
	
	private carroService carroService;
	
	@GetMapping
	
	private ResponseEntity<List<carro>> listaCarros(){
		List<carro> carros = carroService.getAll();
		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
	
	@GetMapping("/{id}")
	
	public ResponseEntity<carro> getCarro(@PathVariable("id") int id) {
	
		carro carro = carroService.getCarroById(id);
	
		if (carro == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(carro);
	
	}
	
	@PostMapping
	
	public ResponseEntity <carro> saveCarro (@RequestBody carro carro) {
		carro newCarro = carroService.save(carro);
		return ResponseEntity.ok(newCarro);
	}
	
	@GetMapping ("/usuario/{usuarioid}")
	
	public ResponseEntity<List<carro>> listarCarrosByUsuarioId (@PathVariable("usuarioid") int id) {
		List<carro> carros = carroService.byUsuarioId(id); 
		if (carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
	
}
