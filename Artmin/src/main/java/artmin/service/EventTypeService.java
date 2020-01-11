/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.service;

import artmin.dao.EventTypeDao;
import artmin.model.EventType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rei
 */
@Service("eventTypeService")
@Transactional
public class EventTypeService {

    @Autowired
    private EventTypeDao dao;

    @Autowired
    EventTypeService eventTypeService; // patch service to autowired

    // zoeken van eventType op basis van ID
    public EventType findById(Long id) {
        return dao.findById(id);
    }

    // zoeken van eventType op basis van ID en naam
    public EventType findSingleEventType(Long artistID, String name) {

        List<EventType> et = dao.findSingleEventType(artistID, name);

        if (et.isEmpty()) {
            // Geen event type gevonden, return null
            return null;
        }

        // geef de eerste oevereenkomende waarde terug
        return et.get(0);
    }

    // Bewaren van eventType
    public void saveEventType(EventType eventType) {
        dao.saveEventType(eventType);
    }

    // bijwerken van bestaande eventType
    public void updateEventType(EventType eventType) {
        EventType entity = dao.findById(eventType.getId());
        if (entity != null) {
            entity.setArtistID(eventType.getArtistID());
            entity.setName(eventType.getName());
        }
    }

    // verwijderen van eventType
    public void deleteEventTypeById(Long id) {
        dao.deleteEventTypeById(id);
    }

    // zoeken van alle eventTypes
    public List<EventType> findAllEventTypes() {
        return dao.findAllEventTypes();
    }

    // zoeken van alle eventTypes
    public List<EventType> findAllArtistEventTypes(Long artistID) {
        return dao.findArtistTypes(artistID);
    }
}
