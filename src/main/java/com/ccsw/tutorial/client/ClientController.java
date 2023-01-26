package com.ccsw.tutorial.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorial.client.model.ClientDto;
import com.devonfw.module.beanmapping.common.api.BeanMapper;

/**
* @author ccsw
*/
@RequestMapping(value = "/client")
@RestController
@CrossOrigin(origins = "*")
public class ClientController {

  @Autowired
  ClientService clientService;

  @Autowired
  BeanMapper beanMapper;

  /**
  * Método para recuperar todas las {@link com.ccsw.tutorial.Client.model.Client}
  * @return
  */
  @RequestMapping(path = "", method = RequestMethod.GET)
  public List<ClientDto> findAll() {

    return this.beanMapper.mapList(this.clientService.findAll(), ClientDto.class);
  }

  /**
  * Método para crear o actualizar una {@link com.ccsw.tutorial.Client.model.Client}
  * @param dto
  * @return
  */
  @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
  public ResponseEntity<ClientDto> save(@PathVariable(name = "id", required = false) Long id, @RequestBody ClientDto dto) {
	  //Si el cliente no existe en la base de datos lo guardamos.
	  if(!clientService.exists(dto.getName())){
		  this.clientService.save(id, dto);
		  return new ResponseEntity<ClientDto>(HttpStatus.OK);
	  }
	  return new ResponseEntity<ClientDto>(HttpStatus.BAD_REQUEST);
  }

  /**
  * Método para borrar una {@link com.ccsw.tutorial.Client.model.Client}
  * @param id
  */
  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable("id") Long id) {

    this.clientService.delete(id);

  }
}