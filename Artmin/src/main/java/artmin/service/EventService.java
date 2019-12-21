/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.service;

import artmin.dao.EventDao;
import artmin.model.Event;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rei
 */
@Service("eventService")
@Transactional
public class EventService {
    @Autowired
    private EventDao dao;
     
    // zoeken van event op basis van ID
    public Event findById(int id) {
        return dao.findById(id);
    }
 
    // Bewaren van event
    public void saveEvent(Event event) {
        dao.saveEvent(event);
    }
 
    // bijwerken van bestaande event
    public void updateEvent(Event event) {
        Event entity = dao.findById(event.getId());
        if(entity!=null){
            entity.setArtistID(event.getArtistID());
            entity.setName(event.getName());
            entity.setTodoAck(event.isTodoAck());
            entity.setDateCalendar(event.getDateCalendar());
            entity.setDateActStart(event.getDateActStart());
            entity.setDateActEnd(event.getDateActEnd());
            entity.setDateAck(event.isDateAck());
            entity.setConfirmedAck(event.isConfirmedAck());
            entity.setLocationID(event.getLocationID());
            entity.setLocationAck(event.isLocationAck());
            entity.setClientID(event.getClientID());
            entity.setClientAck(event.isClientAck());
            entity.setCrowdQty(event.getCrowdQty());
            entity.setCrowdsAvgAge(event.getCrowdsAvgAge());
            entity.setCrowdInformation(event.getCrowdInformation());
            entity.setCrowdAck(event.isCrowdAck());
        }
    }
 
    // verwijderen van event
    public void deleteEventById(long id) {
        dao.deleteEventById(id);
    }
     
    // zoeken van alle events
    public List<Event> findAllEvents() {
        return dao.findAllEvents();
    }
}
