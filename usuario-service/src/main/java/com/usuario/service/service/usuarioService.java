package com.usuario.service.service;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.usuario.service.repository.usuarioRepository;
import com.usuario.service.entities.usuario;
import com.usuario.service.feignclients.carroFeignClients;
import com.usuario.service.feignclients.motoFeignClients;
import com.usuario.service.models.carro;
import com.usuario.service.models.moto;

@Service

public class usuarioService {
	
	@Autowired
	
	private RestTemplate restTemplate;
		
	@Autowired
	
	private usuarioRepository userRepository;

	@Autowired
	private carroFeignClients carroFeignClients;
	
	@Autowired
	private motoFeignClients motoFeignClients;
	
	
	public List<carro> getCarros(int usuarioid) {
	    ResponseEntity<List<carro>> response = restTemplate.exchange(
	    	"http://carro-service/carro/usuario/" + usuarioid,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<List<carro>>() {}
	    );
	    return response.getBody();
	}
	
	public List<moto> getMotos(int usuarioid) {
	    ResponseEntity<List<moto>> response = restTemplate.exchange(
	        "http://moto-service/moto/usuario/" + usuarioid,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<List<moto>>() {}
	    );
	    return response.getBody();
	}
	
	public carro saveCarro (int usuarioid, carro carro) {
		carro.setUsuarioId(usuarioid);
		carro nuevoCarro = carroFeignClients.save(carro);
		return nuevoCarro;
	}
	
	public moto saveMoto (int usuarioid, moto moto) {
		moto.setUsuarioId(usuarioid);
		moto nuevaMoto = motoFeignClients.save(moto);
		return nuevaMoto;
	}
	
	public List<usuario> getAll() {
		return userRepository.findAll();
	}
	
	
	public usuario getUserById(int usuarioid) {
	    return userRepository.findById(usuarioid).orElse(null);
	}
	
	public usuario save(usuario user) {
		usuario newUser = userRepository.save(user);
		return newUser;
	}
	
	public Map<String, Object> getUsuarioAndVehiculos (int usuarioid) {
		
		Map<String, Object> resultado = new HashMap<>();
		
		usuario usuario = userRepository.findById(usuarioid).orElse(null);
		
		if (usuario == null) {
			resultado.put("Mensaje","El usuario no existe !!");
		}
		
		resultado.put("Usuario",usuario);
		
		List<carro> carros = carroFeignClients.getCarros(usuarioid);
		
		if (carros.isEmpty()) {
			resultado.put("Carros","El usuario no tiene carros");
		} else {
			resultado.put("Carros",carros);
		}
		
		List<moto> motos = motoFeignClients.getMotos(usuarioid);
		
		if (motos.isEmpty()) {
			resultado.put("Motos","El usuario no tiene motos");
		} else {
			resultado.put("Motos",motos);
		}
		
		return resultado;
	}
	
}
