package com.usuario.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;   
import org.springframework.stereotype.Repository;

import com.usuario.service.entities.usuario;

@Repository

public interface usuarioRepository extends JpaRepository <usuario, Integer> {

}
