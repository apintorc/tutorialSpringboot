package com.ccsw.tutorial.prestamo;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ccsw.tutorial.prestamo.model.Prestamo;

public interface PrestamoRepository extends CrudRepository<Prestamo, Long> {
	
    /**
    * Método para recuperar un listado paginado de {@link com.ccsw.tutorial.prestamo.model.Prestamo}
    * @param page
    * @return
    */
    Page<Prestamo> findAll(Pageable pageable);

    @Query("select p from Prestamo p where (:gameId is null or p.game.id = :gameId) and (:clientId is null or p.client.id = :clientId) and (:fecha is null  or ( :fecha BETWEEN p.fechaInicio AND p.fechaFin))")
    
    Page<Prestamo> find(Pageable pageable, @Param("gameId") Long gameId, @Param("clientId") Long clientId, @Param("fecha") Date fecha);


    //Ejemplo consulta booleana: SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Company c WHERE c.name = :companyName
	// El mismo juego no puede estar prestado a dos clientes distintos en un mismo día
	@Query("SELECT CASE WHEN COUNT(p) > 1 THEN true ELSE false END FROM Prestamo p WHERE p.game.id = :gameId AND (:fechaInicio BETWEEN p.fechaInicio AND p.fechaFin) OR  (:fechaFin BETWEEN p.fechaInicio AND p.fechaFin)")
	boolean juegoReservado(@Param("gameId") Long gameId, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

	
	// Un mismo cliente no puede tener prestados más de 2 juegos en un mismo día. 
	@Query("SELECT CASE WHEN COUNT(p) > 2 THEN true ELSE false END FROM Prestamo p WHERE p.client.id = :clienteId AND (:fechaInicio BETWEEN p.fechaInicio AND p.fechaFin) OR  (:fechaFin BETWEEN p.fechaInicio AND p.fechaFin)")
	boolean clienteReserva(@Param("clienteId") Long clienteId, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
	
}