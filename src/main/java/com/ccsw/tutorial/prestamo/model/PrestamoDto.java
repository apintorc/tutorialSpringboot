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

    private Date fechaInicio;

    private Date fechaFin;
    
    
    
    /**
    * @return id
    */
    public Long getId() {

        return this.id;
    }

    /**
    * @param id new value of {@link #getId}.
    */
    public void setId(Long id) {

        this.id = id;
    }

    
    
    

	public GameDto getGame() {
		return this.game;
	}

	public void setGame(GameDto game) {
		this.game = game;
	}

	public ClientDto getClient() {
		return this.client;
	}

	public void setClient(ClientDto client) {
		this.client = client;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
    



  


    
    

}
