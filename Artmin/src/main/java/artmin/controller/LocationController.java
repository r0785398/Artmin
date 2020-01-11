package artmin.controller;

import artmin.model.Artist;
import artmin.model.Event;
import artmin.model.EventLocation;
import artmin.model.Note;
import artmin.service.ArtistService;
import artmin.service.EventLocationService;
import artmin.service.EventService;
import artmin.service.NoteService;

import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    ArtistService artistService;

    @Autowired
    NoteService noteService;

    @Autowired
    EventService eventService; // patch service to autowired

    @Autowired
    EventLocationService eventLocationService;

    // NEW GET
    @RequestMapping(value = {"/new-{eventID}"}, method = RequestMethod.GET)
    public String newItem(@PathVariable Long eventID, ModelMap model) {

        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);

        // Init object
        EventLocation location = new EventLocation();
        model.addAttribute("location", location);

        // Set new
        model.addAttribute("edit", false);
        return "locationnew"; // view
    }

    // NEW POST
    @RequestMapping(value = {"/new-{eventID}"}, method = RequestMethod.POST)
    public String saveItem(EventLocation location, @PathVariable Long eventID, BindingResult result, ModelMap model) {

        // Check of alle velden zijn ingevuld en zet "ACK"
        location.isComplete();

        // attach artist
        location.setArtist(artistService.findById(location.getArtistID()));

        //Save to DB
        eventLocationService.saveEventLocation(location);

        // Get Back Location
        EventLocation newLocation = eventLocationService.findSingleEventLocation(location.getArtistID(), location.getName());

        // terug naar overzicht
        return addLocationToEvent(eventID, newLocation.getId(), model);
    }

    // UPDATE GET
    @RequestMapping(value = {"/edit-{locationID}-{eventID}"}, method = RequestMethod.GET)
    public String editItem(@PathVariable Long locationID, @PathVariable Long eventID, ModelMap model) {
        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);

        // Init object
        EventLocation location = eventLocationService.findById(locationID);
        model.addAttribute("location", location);

        // Set new
        model.addAttribute("edit", true);
        return "locationnew"; // view
    }

    // UPDATE POST
    @RequestMapping(value = {"/edit-{locationID}-{eventID}"}, method = RequestMethod.POST)
    public String updateItem(EventLocation location, @PathVariable Long locationID, @PathVariable Long eventID, BindingResult result, ModelMap model) {

        // Check of alle velden zijn ingevuld en zet "ACK"
        location.isComplete();

        // Validatie
        //Save to DB
        eventLocationService.updateEventLocation(location);

        // Get Back Location
        EventLocation newLocation = eventLocationService.findSingleEventLocation(location.getArtistID(), location.getName());

        // terug naar overzicht
        return addLocationToEvent(eventID, newLocation.getId(), model);
    }

    // Delete 
    @RequestMapping(value = {"/delete-{locationID}-{eventID}"}, method = RequestMethod.GET)
    public String deleteItem(@PathVariable Long locationID, @PathVariable Long eventID, ModelMap model) {

        // opzoeken of deze locatie bij een andere event wordt gebruikt
        List<Event> eventsWithType = eventService.findEventsWithLocation(locationID);

        if (eventsWithType.isEmpty()) {
            // er zijn geen events van dit type, verwijder event type

            eventLocationService.deleteEventLocationById(locationID);

        } else {

            JOptionPane.showMessageDialog(null, "Locatie kan niet verwijderd worden, omdat er nog events zijn die dit type gebruiken.", "Alert", JOptionPane.ERROR_MESSAGE);
        }

        // terug naar overzicht
        return list(eventID, model);
    }

    // view all
    @RequestMapping(value = {"all-{eventID}",}, method = RequestMethod.GET)
    public String list(@PathVariable Long eventID, ModelMap model) {

        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);

        // get list
        List<EventLocation> lst = eventLocationService.findAllMyLocations(evnt.getArtistID());
        model.addAttribute("locations", lst);

        return "locationselect"; // naar overzicht
    }

    // Go back to event
    @RequestMapping(value = {"addToEvent-{eventID}-{locationID}",}, method = RequestMethod.GET)
    public String addLocationToEvent(@PathVariable Long eventID, @PathVariable Long locationID, ModelMap model) {

        // Haal alle events met filter: artist ID 
        Event evt = eventService.findById(eventID); // ophalen gegevens uit database
        // Write EventLocation to Event
        evt.setLocationID(locationID);
        evt.setLocation(eventLocationService.findById(locationID));

        if (evt.getLocation().isAck()) {
            // Als de gegevens gevalideerd zijn, kopier dan deze status naar het main event
            evt.setLocationAck(true);
        }

        // WRITE TO DB
        eventService.updateEvent(evt);

        // Readback from DB
        Event newEvent = eventService.findById(eventID); // ophalen gegevens uit database
        model.addAttribute("event", newEvent); //Attribute aan "pagina" model toevoegen naam: users, data= List<Users> met naam lstUsers

        // Artist Info Meenemen in venster
        Artist artist = artistService.findById(evt.getArtistID());
        model.addAttribute("hotartist", artist);

        return "eventdetail"; // JSP Pagina pointer
    }

}
