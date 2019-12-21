/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.service;

import artmin.dao.EventLocationDao;
import artmin.model.EventLocation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rei
 */

@Service("eventLocationService")
@Transactional
public class EventLocationService {
    @Autowired
    private EventLocationDao dao;
     
    // zoeken van eventLocation op basis van ID
    public EventLocation findById(int id) {
        return dao.findById(id);
    }
 
    // Bewaren van eventLocation
    public void saveEventLocation(EventLocation eventLocation) {
        dao.saveEventLocation(eventLocation);
    }
 
    // bijwerken van bestaande eventLocation
    public void updateEventLocation(EventLocation eventLocation) {
        EventLocation entity = dao.findById(eventLocation.getId());
        if(entity!=null){
            entity.setUserID(eventLocation.getUserID());
            entity.setArtistID(eventLocation.getArtistID());
            entity.setName(eventLocation.getName());
            entity.setManager(eventLocation.getManager());
            entity.setStreet(eventLocation.getStreet());
            entity.setNrBus(eventLocation.getNrBus());
            entity.setPostCode(eventLocation.getPostCode());
            entity.setCity(eventLocation.getCity());
            entity.setCountry(eventLocation.getCountry());
            entity.setPhone(eventLocation.getPhone());
            entity.setVat(eventLocation.getVat());
            entity.setEmail(eventLocation.getEmail());
            entity.setAck(eventLocation.isAck());
        }
    }
 
    // verwijderen van eventLocation
    public void deleteEventLocationById(long id) {
        dao.deleteEventLocationById(id);
    }
     
    // zoeken van alle eventLocations
    public List<EventLocation> findAllEventLocations() {
        return dao.findAllEventLocations();
    }
}
