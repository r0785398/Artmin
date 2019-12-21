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
     
    // zoeken van eventType op basis van ID
    public EventType findById(int id) {
        return dao.findById(id);
    }
 
    // Bewaren van eventType
    public void saveEventType(EventType eventType) {
        dao.saveEventType(eventType);
    }
 
    // bijwerken van bestaande eventType
    public void updateEventType(EventType eventType) {
        EventType entity = dao.findById(eventType.getId());
        if(entity!=null){
            entity.setArtistID(eventType.getArtistID());
            entity.setName(eventType.getName());
        }
    }
 
    // verwijderen van eventType
    public void deleteEventTypeById(long id) {
        dao.deleteEventTypeById(id);
    }
     
    // zoeken van alle eventTypes
    public List<EventType> findAllEventTypes() {
        return dao.findAllEventTypes();
    }
}
