package com.carro.service.repository;

import java.util.List;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carro.service.entities.carro;

@Repository

public interface carroRepository extends JpaRepository <carro, Integer>{
	List<carro> findByUsuarioid(int usuarioid);
}
