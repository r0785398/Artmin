package artmin.controller;

import artmin.model.Artist;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import artmin.model.DemoUser;
import artmin.service.ArtistService;
import artmin.service.UserService;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    ArtistController artistController;

    @Autowired
    ArtistService artistService;
    
    @Autowired
    EventController eventController;

    /*
     * This method will list all existing users.
     */
    // *FROM* Route aangeven, deze methode wordt aangesporken als er geen route wordt eengegeven "/" of als de de route "/list" wordt gegeven in de URL
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String start(ModelMap model) {
 
        return "index"; // JSP Pagina pointer
    }
}
