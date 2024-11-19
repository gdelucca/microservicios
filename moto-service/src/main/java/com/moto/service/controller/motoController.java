package com.moto.service.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.entities.moto;
import com.moto.service.services.motoService;


@RestController
@RequestMapping("/moto")

public class motoController {

	@Autowired
	
	private motoService motoService;
	
	@GetMapping
	
	private ResponseEntity<List<moto>> listaMotos(){
		List<moto> moto = motoService.getAll();
		if(moto.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(moto);
	}
	
	@GetMapping("/{id}")
	
	public ResponseEntity<moto> getMoto(@PathVariable("id") int id) {
	
		moto moto = motoService.getMotoById(id);
	
		if (moto == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(moto);
	
	}
	
	@PostMapping
	
	public ResponseEntity <moto> saveMoto (@RequestBody moto moto) {
		moto newMoto = motoService.save(moto);
		return ResponseEntity.ok(newMoto);
	}
	
	@GetMapping ("/usuario/{usuarioid}")
	
	public ResponseEntity<List<moto>> listarMotosByUsuarioId (@PathVariable("usuarioid") int id) {
		List<moto> motos = motoService.byUsuarioId(id);
		if (motos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motos);
	}
	
}

