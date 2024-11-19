package com.usuario.service.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuario.service.models.moto;


@FeignClient(name="moto-service",url= "http://localhost:8003")

@RequestMapping("/moto")

public interface motoFeignClients {
	
	@PostMapping()
	
	public moto save(@RequestBody moto moto);
	
	@GetMapping("/usuario/{usuarioid}")
	
	public List<moto> getMotos(@PathVariable("usuarioid") int usuarioid);
		
}