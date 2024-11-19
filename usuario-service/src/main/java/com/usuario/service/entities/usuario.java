package com.usuario.service.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private int usuarioid;
	private String nombre;
	private String email;
	
	public int getusuarioid() {
		return usuarioid;
	}
	public void setusuarioid(int usuarioid) {
		this.usuarioid = usuarioid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}

