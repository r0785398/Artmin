package artmin.controller;

import artmin.model.Artist;
import artmin.model.Client;
import artmin.model.Event;
import artmin.service.ArtistService;
import artmin.service.ClientService;
import artmin.service.EventLocationService;
import artmin.service.EventService;
import artmin.service.NoteService;

import java.util.List;
import javax.swing.JOptionPane;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ArtistService artistService;

    @Autowired
    NoteService noteService;

    @Autowired
    EventService eventService; // patch service to autowired

    @Autowired
    EventLocationService eventLocationService;

    @Autowired
    ClientService clientService;

    // NEW GET
    @RequestMapping(value = {"/new-{eventID}-{publicclient}"}, method = RequestMethod.GET)
    public String newItem(@PathVariable Long eventID, @PathVariable boolean publicclient, ModelMap model) {

        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);

        // Init object
        Client client = new Client();
        model.addAttribute("client", client);

        model.addAttribute("publicclient", publicclient);

        // Set new
        model.addAttribute("edit", false);
        return "clientnew"; // view
    }

    // NEW POST
    @RequestMapping(value = {"/new-{eventID}-{publicclient}"}, method = RequestMethod.POST)
    public String saveItem(@Valid Client client, @PathVariable Long eventID, @PathVariable boolean publicclient, BindingResult result, ModelMap model) {
        
        if (result.hasErrors()) {
            return "clientnew";
        }
        
        // Check of alle velden zijn ingevuld en zet "ACK"
        client.isComplete();

        // attach artist
        client.setArtist(artistService.findById(client.getArtistID()));

        //Save to DB
        clientService.saveClient(client);

        // Get Back Location
        Client newClient = clientService.findSingleClient(client.getUserID(), client.getName());

        if (publicclient) {
            // Extern invul formulier = return thanks

            String test = addLocationToEvent(eventID, newClient.getId(), model); // niet als page pointer gebruiken
            
            return "publicfinal"; // Static page

        } else {
            // normaal gebruik app
            // terug naar overzicht
            return addLocationToEvent(eventID, newClient.getId(), model);
        }

    }

    // UPDATE GET
    @RequestMapping(value = {"/edit-{clientID}-{eventID}"}, method = RequestMethod.GET)
    public String editItem(@PathVariable Long clientID, @PathVariable Long eventID, ModelMap model) {
        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);

        // Init object
        Client client = clientService.findById(clientID);
        model.addAttribute("client", client);

        // Set new
        model.addAttribute("edit", true);
        return "clientnew"; // view
    }

    // UPDATE POST
    @RequestMapping(value = {"/edit-{clientID}-{eventID}"}, method = RequestMethod.POST)
    public String updateItem(@Valid Client client, @PathVariable Long clientID, @PathVariable Long eventID, BindingResult result, ModelMap model) {
        
        if (result.hasErrors()) {
            return "clientnew";
        }
        
        // Check of alle velden zijn ingevuld en zet "ACK"
        client.isComplete();

        // Validatie
        //Save to DB
        clientService.updateClient(client);

        // Get Back Location
        Client newClient = clientService.findSingleClient(client.getUserID(), client.getName());

        // terug naar overzicht
        return addLocationToEvent(eventID, newClient.getId(), model);
    }

    // Delete 
    @RequestMapping(value = {"/delete-{clientID}-{eventID}"}, method = RequestMethod.GET)
    public String deleteItem(@PathVariable Long clientID, @PathVariable Long eventID, ModelMap model) {

        // opzoeken of deze locatie bij een andere event wordt gebruikt
        List<Event> eventsWithType = eventService.findEventsWithClient(clientID);

        if (eventsWithType.isEmpty()) {
            // er zijn geen events van dit type, verwijder event type

            clientService.deleteClientById(clientID);

        } else {

            JOptionPane.showMessageDialog(null, "Client kan niet verwijderd worden, omdat er nog events zijn die dit type gebruiken.", "Alert", JOptionPane.ERROR_MESSAGE);
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
        List<Client> lst = clientService.finAllMyClients(Long.valueOf(5));
        model.addAttribute("clients", lst);

        return "clientselect"; // naar overzicht
    }

    // Go back to event
    @RequestMapping(value = {"addToEvent-{eventID}-{clientID}",}, method = RequestMethod.GET)
    public String addLocationToEvent(@PathVariable Long eventID, @PathVariable Long clientID, ModelMap model) {

        // Haal alle events met filter: artist ID 
        Event evt = eventService.findById(eventID); // ophalen gegevens uit database

        // Write EventLocation to Event
        evt.setClientID(clientID);
        evt.setClient(clientService.findById(clientID));

        if (evt.getClient().isAck()) {
            // Als de gegevens gevalideerd zijn, kopier dan deze status naar het main event
            evt.setClientAck(true);
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
