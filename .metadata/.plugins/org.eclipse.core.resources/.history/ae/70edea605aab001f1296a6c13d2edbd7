package com.usuario.service.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.usuario.service.models.carro;

/*@FeignClient(name="carro-service",url= "http://localhost:8002")*/

@FeignClient(name="carro-service")

@RequestMapping("/carro")

public interface carroFeignClients {
	
	@PostMapping()
	
	public carro save(@RequestBody carro carro);

	@GetMapping("/usuario/{usuarioid}")
	
	public List<carro> getCarros(@PathVariable("usuarioid") int usuarioid);
		
}
