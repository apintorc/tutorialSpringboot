package com.ccsw.tutorial.prestamo;

import java.util.Date;
import java.util.List;

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

    @Query("select p from Prestamo p where (:gameId is null or p.game.id = :gameId) and (:clientId is null or p.client.id = :clientId) and (:fechaInicio is null or p.fechaInicio = :fechaInicio )AND (:fechaFin IS NULL OR p.fechaFin = :fechaFin )")
    Page<Prestamo> find(Pageable pageable, @Param("gameId") Long gameId, @Param("clientId") Long clientId, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
}
