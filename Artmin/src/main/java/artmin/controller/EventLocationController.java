/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.controller;

import artmin.model.EventLocation;
import artmin.service.EventLocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Rei
 */
@Controller
@RequestMapping("/eventLocation")
public class EventLocationController {
    @Autowired
    EventLocationService eventLocationService;
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newEventLocation(ModelMap model) {
        EventLocation eventLocation = new EventLocation();
        model.addAttribute("eventLocation", eventLocation);
        model.addAttribute("edit", false);
        return "eventLocationregistration"; //view r-team
    }
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveEventLocation(EventLocation eventLocation, BindingResult result, ModelMap model) {
        
        //First check if EventLocation already excists
        List<EventLocation> lstEventLocations = eventLocationService.findAllEventLocations();
        
        for( EventLocation eventLocations : lstEventLocations){
            String eventLocationOutOfList = eventLocations.getName();
            String eventLocationNewinList = eventLocation.getName();
             //&& artists.getDescription() == eventLocation.getDescription() 
            if (eventLocationOutOfList.equals(eventLocationNewinList)){
                model.addAttribute("message", "EventLocation already excists");
                return "eventLocationregistration";
            }
        }
        
        //Save EventLocation to DB
        eventLocationService.saveEventLocation(eventLocation);
        
        //Redirect user to success page
        model.addAttribute("success", "EventLocation " + eventLocation.getName() + " registered successfully");
        return "eventLocationlist"; //view r-team
    }
    
    @RequestMapping(value = {"/edit-{id}-eventLocation"}, method = RequestMethod.GET)
    public String editEventLocation(@PathVariable int id, ModelMap model){
        EventLocation eventLocation = eventLocationService.findById(id);
        model.addAttribute("eventLocation", eventLocation);
        model.addAttribute("edit", true);
        return "eventLocationregistration";
    }
    
    @RequestMapping(value = {"/edit-{id}-eventLocation"}, method = RequestMethod.POST)
    public String updateEventLocation(EventLocation eventLocation, BindingResult result, ModelMap model, @PathVariable int id){
        
        eventLocationService.updateEventLocation(eventLocation);
        
        model.addAttribute("success", "EventLocation " + eventLocation.getName() + " registered successfully");
        return "luckyartist";
    }
    
    @RequestMapping(value = {"/delete-{id}-eventLocation"}, method=RequestMethod.GET)
    public String deleteEventLocation(@PathVariable int id, ModelMap model){
        eventLocationService.deleteEventLocationById(id);
        model.addAttribute("success", "EventLocation verwijderd");
        return "eventLocationlist";
    }
    
    @RequestMapping(value = {"", "/list"}, method = RequestMethod.GET)
    public String listEventLocation(ModelMap model) {
        List<EventLocation> lstEventLocations = eventLocationService.findAllEventLocations(); // ophalen gegevens uit database
        model.addAttribute("artists", lstEventLocations); //Attribute aan "pagina" model toevoegen naam: eventLocations, data= List<EventLocations> met naam lstEventLocations
        return "eventLocationlist"; // JSP Pagina pointer
    }
}
