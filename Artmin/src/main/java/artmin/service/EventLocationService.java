/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.service;

import artmin.dao.EventLocationDao;
import artmin.model.EventLocation;
import artmin.model.EventType;
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
    public EventLocation findById(Long id) {
        return dao.findById(id);
    }

    // zoeken van eventType op basis van ID en naam
    public EventLocation findSingleEventLocation(Long artistID, String name) {

        List<EventLocation> et = dao.findSingleEventType(artistID, name);

        if (et.isEmpty()) {
            // Geen event type gevonden, return null
            return null;
        }

        // geef de eerste oevereenkomende waarde terug
        return et.get(0);
    }

    // Bewaren van eventLocation
    public void saveEventLocation(EventLocation eventLocation) {
        dao.saveEventLocation(eventLocation);
    }

    // bijwerken van bestaande eventLocation
    public void updateEventLocation(EventLocation eventLocation) {
        EventLocation entity = dao.findById(eventLocation.getId());
        if (entity != null) {
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
    public void deleteEventLocationById(Long id) {
        dao.deleteEventLocationById(id);
    }

    // zoeken van alle eventLocations
    public List<EventLocation> findAllEventLocations() {
        return dao.findAllEventLocations();
    }

    // zoeken van alle eventLocations
    public List<EventLocation> findAllMyLocations(Long artistID) {
        return dao.findAllMyLocations(artistID);
    }
}
