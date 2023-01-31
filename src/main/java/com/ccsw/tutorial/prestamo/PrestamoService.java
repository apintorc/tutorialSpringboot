package com.ccsw.tutorial.prestamo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.ccsw.tutorial.prestamo.model.Prestamo;
import com.ccsw.tutorial.prestamo.model.PrestamoDto;
import com.ccsw.tutorial.prestamo.model.PrestamoSearchDto;

/**
* @author ccsw
*/
public interface PrestamoService {

    /**
    * Recupera los préstamos filtrando opcionalmente por juego, cliente y fecha del préstamo.
    * @param idGame
    * @param idClient
    * @param fechaInicio
    * @param fechaFin
    * @return
    */
    List<Prestamo> find(Long idGame, Long idClient, Date fechaInicio, Date fechaFin);

    /**
    * Guarda un préstamo
    * @param id
    * @param dto
    */
    void save(Long id, PrestamoDto dto);
    
    /**
    * Método para recuperar un listado paginado de {@link com.ccsw.tutorial.author.model.Prestamo}
    * @param dto
    * @return
    */
    Page<Prestamo> findPage(PrestamoSearchDto dto);
    
    /**
    * Recupera un listado de prestamos
    * @return
    */
    List<Prestamo> findAll();
    
    /**
    * Método para crear o actualizar un {@link com.ccsw.tutorial.prestamo.model.Prestamo}
    * @param id
    */
    void delete(Long id);

}
