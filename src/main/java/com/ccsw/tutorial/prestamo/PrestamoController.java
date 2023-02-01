package com.ccsw.tutorial.prestamo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorial.prestamo.model.Prestamo;
import com.ccsw.tutorial.prestamo.model.PrestamoDto;
import com.ccsw.tutorial.prestamo.model.PrestamoSearchDto;
import com.ccsw.tutorial.config.mapper.BeanMapper;

/**
* @author ccsw
*/
@RequestMapping(value = "/prestamo")
@RestController
@CrossOrigin(origins = "*")
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;

    @Autowired
    BeanMapper beanMapper;


    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<PrestamoDto> find(
    		@RequestBody PrestamoSearchDto pageable,
    		@RequestParam(value = "gameId", required = false) Long idGame,
            @RequestParam(value = "clientId", required = false) Long idClient, 
            @RequestParam(value = "fechaInicio", required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio , 
            @RequestParam(value = "fechaFin", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {

        Page<Prestamo> prestamos = prestamoService.find(pageable, idGame, idClient, fechaInicio, fechaFin);

        return beanMapper.mapPage(prestamos, PrestamoDto.class);
    }

    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody PrestamoDto dto) {

    	prestamoService.save(id, dto);
    }
    
    /**
    * Método para eliminar un {@link com.ccsw.tutorial.author.model.Author}
    * @param id PK de la entidad
    */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {

        this.prestamoService.delete(id);
    }

}