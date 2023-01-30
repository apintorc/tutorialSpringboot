package com.ccsw.tutorial.prestamo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorial.author.model.AuthorDto;
import com.ccsw.tutorial.author.model.AuthorSearchDto;
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
    
    /**
    * Método para recuperar un listado paginado de {@link com.ccsw.tutorial.prestamo.model.Prestamo}
    * @param dto
    * @return
    */
    
    
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<PrestamoDto> findPage(@RequestBody PrestamoSearchDto dto) {
    	return this.beanMapper.mapPage(this.prestamoService.findPage(dto), PrestamoDto.class);
       
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<PrestamoDto> find(@RequestParam(value = "idGame", required = false) Long idGame,
            @RequestParam(value = "idClient", required = false) Long idClient, 
            @RequestParam(value = "fecha_inicio", required = false) Date fecha_inicio, 
            @RequestParam(value = "fecha_fin", required = false) Date fecha_fin) {

        List<Prestamo> prestamos = prestamoService.find(idGame, idClient, fecha_inicio, fecha_fin);

        return beanMapper.mapList(prestamos, PrestamoDto.class);
    }

    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody PrestamoDto dto) {

    	prestamoService.save(id, dto);
    }

}
