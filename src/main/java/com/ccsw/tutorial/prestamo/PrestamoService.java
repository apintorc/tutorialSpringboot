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
    * @param fecha_inicio
    * @param fecha_fin
    * @return
    */
    List<Prestamo> find(Long idGame, Long idClient, Date fecha_inicio, Date fecha_fin);

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

}
