package com.ccsw.tutorial.prestamo.model;

import com.ccsw.tutorial.game.model.GameDto;

import java.util.Date;

import com.ccsw.tutorial.client.model.ClientDto;

/**
* @author ccsw
*/
public class PrestamoDto {

    private Long id;

    private GameDto game;

    private ClientDto client;

    private Date fecha_inicio;

    private Date fecha_fin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GameDto getGame() {
		return game;
	}

	public void setGame(GameDto game) {
		this.game = game;
	}

	public ClientDto getClient() {
		return client;
	}

	public void setClient(ClientDto client) {
		this.client = client;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
    
    

}
