package com.usuario.service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.entities.usuario;
import com.usuario.service.models.carro;
import com.usuario.service.models.moto;
import com.usuario.service.service.usuarioService;

@RestController
@RequestMapping("/usuario")

public class usuarioController {
	
	@Autowired
	
	private usuarioService usuarioService;
	
	@GetMapping 
	
	public ResponseEntity <List<usuario>> listUsers() {
		
		List<usuario> users = usuarioService.getAll();
		
		if(users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(users);
		
	}
	
	@GetMapping("/{usuarioid}")
	
	public ResponseEntity<usuario> getUser(@PathVariable("usuarioid") int id) {
	
		usuario user = usuarioService.getUserById(id);
	
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(user);
	
	}
	
	@PostMapping
	
	public ResponseEntity <usuario> saveUser (@RequestBody usuario user) {
		usuario newUser = usuarioService.save(user);
		return ResponseEntity.ok(newUser);
	}
	
	@GetMapping("/carros/{usuarioid}")
	
	public ResponseEntity<List<carro>> listarCarros(@PathVariable("usuarioid") int usuarioid) {
		usuario usuario = usuarioService.getUserById(usuarioid);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		List<carro> carros = usuarioService.getCarros(usuarioid);
		return ResponseEntity.ok(carros);
	}

	@GetMapping("/motos/{usuarioid}")
	
	public ResponseEntity<List<moto>> listarMotos(@PathVariable("usuarioid") int usuarioid) {
		usuario usuario = usuarioService.getUserById(usuarioid);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		List<moto> motos = usuarioService.getMotos(usuarioid);
		return ResponseEntity.ok(motos);
	}
	
	@PostMapping("/carro/{usuarioid}")
	public ResponseEntity<carro> guardarCarro (@PathVariable("usuarioid") int usuarioid, @RequestBody carro carro) {
		carro nuevoCarro = usuarioService.saveCarro(usuarioid, carro);
		return ResponseEntity.ok(nuevoCarro);
	}
	
	@PostMapping("/moto/{usuarioid}")
	public ResponseEntity<moto> guardarMoto (@PathVariable("usuarioid") int usuarioid, @RequestBody moto moto) {
		moto nuevaMoto = usuarioService.saveMoto(usuarioid, moto);
		return ResponseEntity.ok(nuevaMoto);
	}
	
	@GetMapping("/todos/{usuarioid}")
	public ResponseEntity<Map<String, Object>> listarTodosLosVehiculos(@PathVariable("usuarioid") int usuarioid) {
		Map<String, Object> resultado = usuarioService.getUsuarioAndVehiculos(usuarioid);
		return ResponseEntity.ok(resultado);
	}
}
