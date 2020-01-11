/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.service;

import artmin.dao.ClientDao;
import artmin.dao.EventDao;
import artmin.dao.EventLocationDao;
import artmin.dao.EventTypeDao;
import artmin.dao.NoteDao;
import artmin.dao.TodoDao;
import artmin.model.Client;
import artmin.model.Event;
import artmin.model.EventLocation;
import artmin.model.EventType;
import artmin.model.Note;
import artmin.model.Payment;
import artmin.model.Todo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private EventTypeDao eventDao;

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private TodoDao todoDao;

    @Autowired
    private EventLocationDao eventLocationDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    EventTypeService eventTypeService; // patch service to autowired

    @Autowired
    NoteService noteService; // patch service to autowired

    @Autowired
    TodoService todoService; // patch service to autowired

    // zoeken van event op basis van ID
    public Event findById(Long id) {

        // Ophalen van event uit database
        Event evt = dao.findById(id);

        // Aanvullen van event objects
        FillEvent(evt);

        // Return compleet event
        return evt;
    }

    // Bewaren van event
    public void saveEvent(Event event) {
        dao.saveEvent(event);
    }

    // bijwerken van bestaande event
    public void updateEvent(Event event) {
        Event entity = dao.findById(event.getId());
        if (entity != null) {
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
            entity.setCanceledAck(event.isCanceledAck());
        }
    }

    // verwijderen van event
    public void deleteEventById(Long eventID) {
        // Delete eerste alle onderliggende objecten
        paymentService.deleteAllPayments(eventID); // payments
        noteService.deleteAllNotes(eventID); // Notes
        todoService.deleteAllTodo(eventID);

        // Verwijder event
        dao.deleteEventById(eventID);
    }

    // zoeken van alle events
    public List<Event> findUpcommingEvents(Long artistID) {

        List<Event> evnt = new ArrayList<Event>();
        evnt.addAll(dao.findUpcommingEvents(artistID));

        for (Event tmp : evnt) {
            FillEvent(tmp);
        }

        return evnt;
    }

    // zoeken van alle events
    public List<Event> findAllEvents(Long artistID) {

        List<Event> evnt = new ArrayList<Event>();
        evnt.addAll(dao.findAllEvents(artistID));

        for (Event tmp : evnt) {
            FillEvent(tmp);
        }

        return evnt;
    }

    // Enkel ecents die nog niet OK zijn
    public List<Event> findAllEventsNotOK(Long artistID) {

        List<Event> evnt = new ArrayList<Event>();
        evnt.addAll(dao.findAllEventsNotOK(artistID));

        for (Event tmp : evnt) {
            FillEvent(tmp);
        }

        return evnt;
    }
    
        // Laatst aangemaakt event
    public Event findEventByName(Long artistID, String name) {

        List<Event> evnt = new ArrayList<Event>();
        evnt.addAll(dao.findEventByName(artistID, name));

        if (evnt.isEmpty()) {
            // Geen event type gevonden, return null
            return null;
        }

        Event ev = evnt.get(0);
        
        this.FillEvent(ev);
        
        // geef de eerste oevereenkomende waarde terug
        return ev;
    }
        
       

    public List<Event> findEventsWithType(Long eventtypeID) {

        List<Event> evnt = new ArrayList<Event>();

        EventType evt = eventTypeService.findById(eventtypeID);

        evnt.addAll(dao.findEventsWithType(evt));

        return evnt;
    }

    public List<Event> findEventsWithLocation(Long locationID) {

        List<Event> evnt = new ArrayList<Event>();
        evnt.addAll(dao.findEventsWithLocation(locationID));

        return evnt;
    }

    public List<Event> findEventsWithClient(Long clientID) {

        List<Event> evnt = new ArrayList<Event>();

        evnt.addAll(dao.findEventsWithClient(clientID));

        return evnt;
    }

    public void FillEvent(Event evt) {
        // EVENT TYPE OPHALEN
        // EVENT TYPE OPHALEN
        // EVENT TYPE OPHALEN
        EventType eventType = eventDao.findById(evt.getEventTypeID()); // Ophalen van eventType
        evt.setEventType(eventType); // Voeg Event Type toe aan lijst gegeven 

        // Status kleur en prioriteiten text invullen
        evt.statusSwitch();

        // Aantal onderliggende notities ophalen
        List<Note> notes = noteDao.findAllNotes(evt.getId());
        evt.setAantalNotes(notes.size());

        // TODO'S
        // Aantal ALLE onderliggende notities ophalen
        List<Todo> todos = todoDao.findAllTodos(evt.getId());
        evt.setAantalTodo(todos.size());

        // aantal complete onderlggende todo's ophalen
        List<Todo> todosAck = todoDao.findAllTodosAck(evt.getId());
        evt.setAantalTodoAck(todosAck.size());

        if (todos.size() > 0) {
            if ((todos.size() == todosAck.size())) {
                // Alle todo's zijn verwerkt
                evt.setTodoAck(true);
                this.saveEvent(evt);
            }
        }

        // aantal ALLE onderliggende payments ophalen
        List<Payment> allPayments = paymentService.findAllpayments(evt.getId());
        evt.setAantalPayments(allPayments.size());

        // aantal ACK payments ophalen
        List<Payment> allAckPayments = paymentService.findAllPaymentsAck(evt.getId());
        evt.setAantalPaymentsAck(allAckPayments.size());

        // Event locatie ophalen
        if (evt.getLocationID() > 0) {
            EventLocation eventLocation = eventLocationDao.findById(evt.getLocationID());
            evt.setLocation(eventLocation);
        }

        // Klantgegevens ophalen
        if (evt.getClientID() > 0) {
            Client client = clientDao.findById(evt.getClientID());
            evt.setClient(client);
        }

    }
}
