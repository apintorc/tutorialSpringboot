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
    //@Query("SELECT p FROM Prestamo p WHERE (:gameId IS NULL OR p.game.id = :gameId) AND (:clientId IS NULL OR p.client.id = :clientId) AND (:fechaPrestamo IS NULL OR (p.fecha_prestamo <= :fechaPrestamo AND p.fecha_devolucion > :fechaPrestamo))")
    @Query("select p from Prestamo p where (:gameId is null or p.game.id = :gameId) and (:clientId is null or p.client.id = :clientId) and (:fecha is null  or ( :fecha BETWEEN p.fechaInicio AND p.fechaFin))")
    
    Page<Prestamo> find(Pageable pageable, @Param("gameId") Long gameId, @Param("clientId") Long clientId, @Param("fecha") Date fecha);
}
