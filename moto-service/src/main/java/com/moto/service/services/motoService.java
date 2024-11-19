package com.moto.service.services;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import com.moto.service.entities.moto;
import com.moto.service.repository.motoRepository;

@Service

public class motoService {
	
	@Autowired
	
	private motoRepository motoRepository;
	
	public List<moto> getAll() {
		return motoRepository.findAll();
	}

	public moto getMotoById (int id) {
		return motoRepository.findById(id).orElse(null);
	}
	
	public moto save (moto moto) {
		moto nuevaMoto = motoRepository.save(moto);
		return nuevaMoto;
	}
	
	public List<moto> byUsuarioId (int usuarioid) {
		return motoRepository.findByUsuarioid(usuarioid);
	}
}

