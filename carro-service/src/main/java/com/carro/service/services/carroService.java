package com.carro.service.services;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import com.carro.service.entities.carro;
import com.carro.service.repository.carroRepository;

@Service

public class carroService {
	
	@Autowired
	
	private carroRepository carroRepository;
	
	public List<carro> getAll() {
		return carroRepository.findAll();
	}

	public carro getCarroById (int id) {
		return carroRepository.findById(id).orElse(null);
	}
	
	public carro save (carro carro) {
		carro nuevoCarro = carroRepository.save(carro);
		return nuevoCarro;
	}
	
	public List<carro> byUsuarioId (int usuarioid) {
		return carroRepository.findByUsuarioid(usuarioid);
	}
}
