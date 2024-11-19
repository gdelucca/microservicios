package com.moto.service.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.moto.service.entities.moto;

@Repository

public interface motoRepository extends JpaRepository <moto, Integer>{
	List<moto> findByUsuarioid(int usuarioid);
}
