package com.ccsw.tutorial.client;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;
    
    public static final String CLIENT_NAME = "CAT1";
    public static final Long EXISTS_CLIENT_ID = 1L;
    public static final Long NOT_EXISTS_CLIENT_ID = 567L;

    @Test
    public void findAllShouldReturnAllClients() {

          List<Client> list = new ArrayList<>();
          list.add(mock(Client.class));

          when(clientRepository.findAll()).thenReturn(list);

          List<Client> clients = clientService.findAll();

          assertNotNull(clients);
          assertEquals(1, clients.size());
    }

    @Test
    public void saveNotExistsClientIdShouldInsert() {

          ClientDto clientDto = new ClientDto();
          clientDto.setName(CLIENT_NAME);

          ArgumentCaptor<Client> cliente = ArgumentCaptor.forClass(Client.class);

          clientService.save(null, clientDto);

          verify(clientRepository).save(cliente.capture());

          assertEquals(CLIENT_NAME, cliente.getValue().getName());
    }
    

    @Test
    public void saveExistsClientIdShouldUpdate() {

      ClientDto clientDto = new ClientDto();
      clientDto.setName(CLIENT_NAME);

      Client client = mock(Client.class);
      when(clientRepository.findById(EXISTS_CLIENT_ID)).thenReturn(Optional.of(client));

      clientService.save(EXISTS_CLIENT_ID, clientDto);

      verify(clientRepository).save(client);
    }
    
    //No debería insertarse ya que el nombre existe en la base de datos
    @Test
    public void saveNotExistsClientIdShouldInsertNameExistsInBbdd() {
    	
    }
    //Si debería insertarse ya que el nombre no existe en la base de datos
    @Test
    public void saveNotExistsClientIdShouldInsertNameNotExistsInBbdd() {
    	
    }
    
    //No debería actualizarse ya que el nombre existe en la base de datos
    @Test
    public void saveNotExistsClientIdShouldUpdateNameExistsInBbdd() {
    	
    }
    //Si debería actualizarse ya que el nombre no existe en la base de datos
    @Test
    public void saveNotExistsClientIdShouldUpdateNameNotExistsInBbdd() {
    	
    }
    
    @Test
    public void deleteExistsClientIdShouldDelete() {

    	clientService.delete(EXISTS_CLIENT_ID);

        verify(clientRepository).deleteById(EXISTS_CLIENT_ID);
    }
    
    @Test
    public void getExistsClientIdShouldReturnCategory() {

          Client client = mock(Client.class);
          when(client.getId()).thenReturn(EXISTS_CLIENT_ID);
          when(clientRepository.findById(EXISTS_CLIENT_ID)).thenReturn(Optional.of(client));

          Client clientResponse = clientService.get(EXISTS_CLIENT_ID);

          assertNotNull(clientResponse);
          assertEquals(EXISTS_CLIENT_ID, client.getId());
    }

    @Test
    public void getNotExistsClientIdShouldReturnNull() {

          when(clientRepository.findById(NOT_EXISTS_CLIENT_ID)).thenReturn(Optional.empty());

          Client category = clientService.get(NOT_EXISTS_CLIENT_ID);

          assertNull(category);
    }




}
