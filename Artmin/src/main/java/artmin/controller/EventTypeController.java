// Bram 0Som
// Created: 21/12/2019
package artmin.controller;

import artmin.model.Artist;
import artmin.model.Event;
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
import javax.swing.JOptionPane;

import javax.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/eventtypes")
public class EventTypeController {

    @Autowired
    EventService eventService; // patch service to autowired

    @Autowired
    ArtistService artistService; // patch service to autowired

    @Autowired
    EventTypeService eventTypeService; // patch service to autowired

    // NEW EVENT TYPE
    // NEW EVENT TYPE
    // NEW EVENT TYPE
    @RequestMapping(value = {"/new-{artistID}-{eventID}-{newType}"}, method = RequestMethod.GET)
    public String newEventType(@PathVariable Long artistID, @PathVariable Long eventID, @PathVariable boolean newType, ModelMap model) {

        // Artist Info Meenemen in venster
        Artist artist = artistService.findById(artistID);
        model.addAttribute("hotartist", artist);

        // Edit attribute
        model.addAttribute("edit", false);

        // List Of Event Types
        List<EventType> lstEventTypes = eventTypeService.findAllArtistEventTypes(artistID);
        model.addAttribute("eventtypes", lstEventTypes); //Attribute aan "pagina" model toevoegen

        if (lstEventTypes.isEmpty() || newType) {
            // New Events Instance
            EventType eventtype = new EventType();
            model.addAttribute("eventtype", eventtype);

            return "eventtypenew"; //view r-team
        }

        return "eventytypeselect"; //view r-team
    }

    // select event from list
    @RequestMapping(value = {"/select-{artistID}-{eventID}-{eventtypeID}"}, method = RequestMethod.GET)
    public String selecteventType(@PathVariable Long artistID, @PathVariable Long eventID, @PathVariable Long eventtypeID, ModelMap model) {

        // Ga terug naar nieuw event of naar bestaand event
        return SwitchToEvent(artistID, eventID, eventtypeID, model);
    }

    // Add EVENTTYPE
    @RequestMapping(value = {"/new-{artistID}-{eventID}"}, method = RequestMethod.POST)
    public String addEventType(EventType eventtype, @PathVariable Long artistID, @PathVariable Long eventID, BindingResult result, ModelMap model) {

        // ophalen van artist object
        eventtype.setArtist(artistService.findById(artistID));

        // Save event type naar database
        eventTypeService.saveEventType(eventtype);

        // call Back event type from database
        EventType et = eventTypeService.findSingleEventType(artistID, eventtype.getName());

        return SwitchToEvent(artistID, eventID, et.getId(), model);
    }

    public String SwitchToEvent(Long artistID, Long eventID, Long eventtypeID, ModelMap model) {
        // Return schakelen tussen bestaand of nieuw event

        // Ophalen van eventtype object
        EventType et = eventTypeService.findById(eventtypeID);

        if (et != null) {
            // er komt een eventtype terug

            if (eventID != null) {
                // vertrokken van een bepaald event "edit" ga terug naar het event

            }

            // blanco start ga terug naar nieuw event window
            // New Events Instance
            Event event = new Event();
            model.addAttribute("event", event);

            // Artist Info Meenemen in venster
            Artist artist = artistService.findById(artistID);
            model.addAttribute("hotartist", artist);

            // eventtype toevoegen
            model.addAttribute("eventtype", et);

            return "eventsnew";
        }

        // geen event type terug
        // ga terug naar het aanmaken van een event type 
        return newEventType(artistID, eventID, false, model);

    }

    //DELETE - EVENTTYPE
    //DELETE - EVENTTYPE
    //DELETE - EVENTTYPE
    @RequestMapping(value = {"/delete-{artistID}-{eventID}-{eventtypeID}"}, method = RequestMethod.GET)
    public String deleteEvent(@PathVariable Long artistID, @PathVariable Long eventID, @PathVariable Long eventtypeID, ModelMap model) {

        // opzoeken of dit type ergens word gebruiker
        List<Event> eventsWithType = eventService.findEventsWithType(eventtypeID);

        if (eventsWithType.isEmpty()) {
            // er zijn geen events van dit type, verwijder event type
            eventTypeService.deleteEventTypeById(eventtypeID);

        } else {

            JOptionPane.showMessageDialog(null, "Type kan niet verwijderd worden, omdat er nog events zijn die dit type gebruiken.", "Alert", JOptionPane.ERROR_MESSAGE);
        }

        // Ga terug naar nieuw event of naar bestaand event
        return SwitchToEvent(artistID, eventID, eventtypeID, model);
    }

    //EDIT - EVENTTYPE
    //EDIT - EVENTTYPE
    //EDIT - EVENTTYPE
    @RequestMapping(value = {"/edit-{artistID}-{eventID}-{eventtypeID}"}, method = RequestMethod.GET)
    public String editEvent(@PathVariable Long artistID, @PathVariable Long eventID, @PathVariable Long eventtypeID, ModelMap model) {

        // Artist Info Meenemen in venster
        Artist artist = artistService.findById(artistID);
        model.addAttribute("hotartist", artist);

        // find event type
        EventType eventtype = eventTypeService.findById(eventtypeID);
        model.addAttribute("eventtype", eventtype);

        // Edit attribute
        model.addAttribute("edit", true);

        return "eventtypenew";
    }

    @RequestMapping(value = {"/edit-{artistID}-{eventID}"}, method = RequestMethod.POST)
    public String UpdateEvent(EventType eventtype, @PathVariable Long artistID, @PathVariable Long eventID, ModelMap model) {

        eventTypeService.updateEventType(eventtype);

        return newEventType(artistID, eventID, false, model);
    }
}
