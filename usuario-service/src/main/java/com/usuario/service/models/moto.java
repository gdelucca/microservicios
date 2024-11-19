package com.usuario.service.models;

public class moto {

	private String marca;
	private String modelo;
	private int usuarioid;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setUsuarioId(int usuarioid) {
		this.usuarioid = usuarioid;
	}

	public int getUsuarioId() {
		return usuarioid;
	}

	
	public moto() {
		super();
	}

}
