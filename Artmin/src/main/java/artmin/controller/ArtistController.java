/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.controller;

import artmin.model.Artist;
import artmin.service.ArtistService;

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
 * @author r0798566
 */
@Controller
@RequestMapping("/artist")
public class ArtistController {
    
    @Autowired
    ArtistService artistService;
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newArtist(ModelMap model) {
        Artist artist = new Artist();
        model.addAttribute("artist", artist);
        model.addAttribute("edit", false);
        return "artistregistration"; //view r-team
    }
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveArtist(Artist artist, BindingResult result, ModelMap model) {
        
        //First check if user already excists
        List<Artist> lstArtists = artistService.findAllArtists();
        
        for( Artist artists : lstArtists){
            String artistOutOfList = artists.getName();
            String artistNewinList = artist.getName();
             //&& artists.getDescription() == artist.getDescription() 
            if (artistOutOfList.equals(artistNewinList)){
                model.addAttribute("message", "Artist already excists");
                return "artistregistration";
            }
        }
        
        //Save user to DB
        artistService.saveArtist(artist);
        
        //Redirect user to success page
        model.addAttribute("success", "Artist " + artist.getName() + " registered successfully");
        return "luckyartist"; //view r-team
    }
    
    @RequestMapping(value = {"/edit-{id}-artist"}, method = RequestMethod.GET)
    public String editArtist(@PathVariable int id, ModelMap model){
        Artist artist = artistService.findById(id);
        model.addAttribute("artist", artist);
        model.addAttribute("edit", true);
        return "artistregistration";
    }
    
    @RequestMapping(value = {"/edit-{id}-artist"}, method = RequestMethod.POST)
    public String updateArtist(Artist artist, BindingResult result, ModelMap model, @PathVariable int id){
        
        artistService.updateArtist(artist);
        
        model.addAttribute("success", "Artist " + artist.getName() + " registered successfully");
        return "luckyartist";
    }
    
    @RequestMapping(value = {"/delete-{id}-artist"}, method=RequestMethod.GET)
    public String deleteArtist(@PathVariable int id, ModelMap model){
        artistService.deleteArtistById(id);
        model.addAttribute("success", "Artist verwijderd");
        return "luckyartist";
    }
    
    @RequestMapping(value = {"", "/list"}, method = RequestMethod.GET)
    public String listArtist(ModelMap model) {
        List<Artist> lstArtists = artistService.findAllArtists(); // ophalen gegevens uit database
        model.addAttribute("artists", lstArtists); //Attribute aan "pagina" model toevoegen naam: users, data= List<Users> met naam lstUsers
        return "allartists"; // JSP Pagina pointer
    }

}