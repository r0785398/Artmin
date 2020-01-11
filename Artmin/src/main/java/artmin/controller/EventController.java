// Bram 0Som
// Created: 21/12/2019
package artmin.controller;

import artmin.model.Artist;
import artmin.model.Crowd;
import artmin.model.Event;
import artmin.model.EventDate;
import artmin.model.EventType;
import artmin.service.ArtistService;
import artmin.service.EventService;
import artmin.service.EventTypeService;
import java.util.Date;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService; // patch service to autowired

    @Autowired
    ArtistService artistService; // patch service to autowired

    @Autowired
    EventTypeService eventTypeService; // patch service to autowired

    // EVENT OVERVIEW
    // EVENT OVERVIEW
    // EVENT OVERVIEW
    // ENKEL EVENTS DIE KOMENDE ZIJN >>>
    @RequestMapping(value = {"/opn-events-{artistID}"}, method = RequestMethod.GET)
    public String ListUpcommingEvents(@PathVariable Long artistID, ModelMap model) {

        List<Event> lstEventsnok = eventService.findAllEventsNotOK(artistID); // ophalen gegevens uit database
        model.addAttribute("eventsnok", lstEventsnok); //Attribute aan "pagina" model toevoegen naam: users, data= List<Users> met naam lstUsers

        // Haal alle events met filter: artist ID 
        List<Event> lstEvents = eventService.findUpcommingEvents(artistID); // ophalen gegevens uit database
        model.addAttribute("events", lstEvents); //Attribute aan "pagina" model toevoegen naam: users, data= List<Users> met naam lstUsers

        // Artist Info Meenemen in venster
        Artist artist = artistService.findById(artistID);
        model.addAttribute("hotartist", artist);

        return "eventsall"; // JSP Pagina pointer
    }

    // EVENT OVERVIEW
    // EVENT OVERVIEW
    // EVENT OVERVIEW
    // ALLE EVENTS
    @RequestMapping(value = {"/opn-events-all-{artistID}"}, method = RequestMethod.GET)
    public String listEventsAll(@PathVariable Long artistID, ModelMap model) {

        // Haal alle events met filter: artist ID 
        List<Event> lstEvents = eventService.findAllEvents(artistID); // ophalen gegevens uit database
        model.addAttribute("events", lstEvents); //Attribute aan "pagina" model toevoegen naam: users, data= List<Users> met naam lstUsers

        // Artist Info Meenemen in venster
        Artist artist = artistService.findById(artistID);
        model.addAttribute("hotartist", artist);

        return "eventsall"; // JSP Pagina pointer
    }

    @RequestMapping(value = {"/detail-{eventID}"}, method = RequestMethod.GET)
    public String eventDetail(@PathVariable Long eventID, ModelMap model) {
        // Haal alle events met filter: artist ID 
        Event evt = eventService.findById(eventID); // ophalen gegevens uit database
        model.addAttribute("event", evt); //Attribute aan "pagina" model toevoegen naam: users, data= List<Users> met naam lstUsers

        // Artist Info Meenemen in venster
        Artist artist = artistService.findById(evt.getArtistID());
        model.addAttribute("hotartist", artist);

        return "eventdetail"; // JSP Pagina pointer
    }

    @RequestMapping(value = {"/ack-{eventID}-{pointer}"}, method = RequestMethod.GET)
    public String ackItem(@PathVariable Long eventID, @PathVariable int pointer, ModelMap model) {

        // Fill Event
        Event evt = eventService.findById(eventID); // ophalen gegevens uit database        

        // Set status
        switch (pointer) {
            case 1:
                // Ack TODO
                if (evt.isTodoAck()) {
                    evt.setTodoAck(false);
                } else {
                    evt.setTodoAck(true);
                }

                break;
            case 2:
                // Ack Date
                if (evt.isDateAck()) {
                    evt.setDateAck(false);
                } else {
                    evt.setDateAck(true);
                }
                break;
            case 3:
                // Ack Confirmed
                if (evt.isConfirmedAck()) {
                    evt.setConfirmedAck(false);
                } else {
                    evt.setConfirmedAck(true);
                }
                break;
            case 4:
                // Ack Location
                if (evt.isLocationAck()) {
                    evt.setLocationAck(false);
                } else {
                    evt.setLocationAck(true);
                }
                break;
            case 5:
                // Ack Client
                if (evt.isClientAck()) {
                    evt.setClientAck(false);
                } else {
                    evt.setClientAck(true);
                }
                break;
            case 6:
                // Ack Crowd
                if (evt.isCrowdAck()) {
                    evt.setCrowdAck(false);
                } else {
                    evt.setCrowdAck(true);
                }
                break;
            case 7:
                // Ack Crowd
                if (evt.isCanceledAck()) {
                    evt.setCanceledAck(false);
                } else {
                    evt.setCanceledAck(true);
                }
                break;
            default:
            // code block
        }

        // Update status naar DB
        eventService.updateEvent(evt);

        // Return Event Detail
        return eventDetail(eventID, model); // JSP Pagina pointer
    }

    @RequestMapping(value = {"/new-{artistID}"}, method = RequestMethod.POST)
    public String saveEvent(Event event, BindingResult result, ModelMap model) {

        // Ophalen van Event object
        event.setEventType(eventTypeService.findById(event.getEventTypeID()));

        // Ophalen van artiest object
        event.setArtist(artistService.findById(event.getArtistID()));

        //Save user to DB
        eventService.saveEvent(event);

        Event eventCallBack = eventService.findEventByName(event.getArtistID(), event.getName());

        if (eventCallBack != null) {
            // Event gevonden ga naar detail
            return eventDetail(eventCallBack.getId(), model);
        } else {
            // ga naar overzicht
            // Return terug naar het overzicht van events
            return this.ListUpcommingEvents(event.getArtistID(), model);
        }
    }

    //DELETE - EVENT
    //DELETE - EVENT
    //DELETE - EVENT
    @RequestMapping(value = {"/delete-{id}-event-{artistID}"}, method = RequestMethod.GET)
    public String deleteEvent(@PathVariable Long id, @PathVariable Long artistID, ModelMap model) {
        eventService.deleteEventById(id);

        // Return terug naar het overzicht van events
        return this.ListUpcommingEvents(artistID, model);
    }

    // POST CROWD
    @RequestMapping(value = {"/crowd-{eventID}"}, method = RequestMethod.POST)
    public String setCrowd(Crowd crowd, @PathVariable Long eventID, ModelMap model) {

// Haal alle events met filter: artist ID 
        Event evt = eventService.findById(eventID); // ophalen gegevens uit database
        evt.setCrowdAck(crowd.isCrowdAck());
        evt.setCrowdInformation(crowd.getCrowdInformation());
        evt.setCrowdQty(crowd.getCrowdQty());
        evt.setCrowdsAvgAge(crowd.getCrowdsAvgAge());

        // Update status naar DB
        eventService.updateEvent(evt);

        return eventDetail(eventID, model); // JSP Pagina pointer
    }

    @RequestMapping(value = {"/date-{eventID}"}, method = RequestMethod.GET)
    public String getDate(@PathVariable Long eventID, ModelMap model) {
        Event evt = eventService.findById(eventID); // ophalen gegevens uit database        

        // Event naar view pathen
        model.addAttribute("event", evt);

        EventDate edate = evt.getStringDates();

        model.addAttribute("edate", edate); //Attribute aan "pagina" model toevoegen naam: users, data= List<Users> met naam lstUsers
        return "dateedit"; // JSP Pagina pointer
    }

        // GET CROWD
    @RequestMapping(value = {"/crowd-{eventID}"}, method = RequestMethod.GET)
    public String getCrowd(@PathVariable Long eventID, ModelMap model) {
        // Haal alle events met filter: artist ID 
        Event evt = eventService.findById(eventID); // ophalen gegevens uit database

        Crowd crowd = new Crowd();
        crowd.setCrowdAck(evt.isCrowdAck());
        crowd.setCrowdInformation(evt.getCrowdInformation());
        crowd.setCrowdQty(evt.getCrowdQty());
        crowd.setCrowdsAvgAge(evt.getCrowdsAvgAge());

         // Event naar view pathen
        model.addAttribute("event", evt);
        
        model.addAttribute("crowd", crowd); //Attribute aan "pagina" model toevoegen naam: users, data= List<Users> met naam lstUsers

        return "crowdedit"; // JSP Pagina pointer
    }
    
    // POST CROWD
    @RequestMapping(value = {"/date-{eventID}"}, method = RequestMethod.POST)
    public String setDate(EventDate edate, @PathVariable Long eventID, ModelMap model) {
        // Event inladen
        Event evt = eventService.findById(eventID); // ophalen gegevens uit database

        if (evt.SetEventDate(edate)) {
            // Save aangepaste datum naar DB
            eventService.updateEvent(evt);

            return eventDetail(eventID, model); // JSP Pagina pointer

        } else {
            // fout bij omzetten datum
            String error = "Fout bij inageve datum";
            model.addAttribute("error", error); //Attribute aan "pagina" model toevoegen naam: users, data= List<Users> met naam lstUsers

            // Event naar view pathen
            model.addAttribute("event", evt);

            EventDate newEDate = new EventDate();
            model.addAttribute("edate", edate); //Attribute aan "pagina" model toevoegen naam: users, data= List<Users> met naam lstUsers
            return "dateedit"; // JSP Pagina pointer

        }

    }

}
