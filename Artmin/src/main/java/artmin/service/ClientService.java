/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.service;

import artmin.dao.ClientDao;
import artmin.model.Client;
import artmin.model.EventLocation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rei
 */

@Service("clientService")
@Transactional
public class ClientService {
    
    @Autowired
    private ClientDao dao;
     
    // zoeken van client op basis van ID
    public Client findById(Long id) {
        return dao.findById(id);
    }
     
        // zoeken van eventType op basis van ID en naam
    public Client findSingleClient(Long clientID, String name) {

        List<Client> et = dao.findSingleClient(clientID, name);

        if (et.isEmpty()) {
            // Geen event type gevonden, return null
            return null;
        }

        // geef de eerste oevereenkomende waarde terug
        return et.get(0);
    }
    
    // Bewaren van gebruiker
    public void saveClient(Client client) {
        dao.saveClient(client);
    }
 
    // bijwerken van bestaande gebruiker
    public void updateClient(Client client) {
        Client entity = dao.findById(client.getId());
        if(entity!=null){
            entity.setName(client.getName());
            entity.setStreet(client.getStreet());
            entity.setNrBus(client.getNrBus());
            entity.setPostCode(client.getPostCode());
            entity.setCity(client.getCity());
            entity.setCountry(client.getCountry());
            entity.setPhone(client.getPhone());
            entity.setEmail(client.getEmail());
            entity.setVat(client.getVat());
            entity.setAck(client.isAck());
        }
    }
 
    // verwijderen van gebruiker
    public void deleteClientById(Long id) {
        dao.deleteClientById(id);
    }
     
    // zoeken van alle gebruikers
    public List<Client> findAllClients() {
        return dao.findAllClients();
    }
    
       // zoeken van alle eventLocations
    public List<Client> finAllMyClients(Long userID) {
        return dao.finAllMyClients(userID);
    }
}
