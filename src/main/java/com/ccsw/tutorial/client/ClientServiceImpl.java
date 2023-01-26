package com.ccsw.tutorial.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;



/**
* @author ccsw
*
*/
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    /**
    * {@inheritDoc}
    */
    @Override
    public Client get(Long id) {

        return this.clientRepository.findById(id).orElse(null);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public List<Client> findAll() {

        return (List<Client>) this.clientRepository.findAll();
    }
    

     public boolean exists(String name){
        return clientRepository.existsByName(name);
     }

    /**
    * {@inheritDoc}
    */
    @Override
    public void save(Long id, ClientDto dto) {

    	Client cliente = null;

        if (id == null)
        	cliente = new Client();
        else
        	cliente = this.get(id);

        cliente.setName(dto.getName());

        this.clientRepository.save(cliente);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void delete(Long id) {

        this.clientRepository.deleteById(id);

    }
}