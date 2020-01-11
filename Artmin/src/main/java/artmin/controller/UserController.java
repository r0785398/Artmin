package artmin.controller;

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

@Controller
@RequestMapping("/artmin")
public class UserController {

    @RequestMapping(value = {"", "/login"}, method = RequestMethod.GET)
    public String loginUser(ModelMap model) {

        // verzamelen gegevens voor het login venster
        return "login"; // JSP Pagina pointer
    }

    @RequestMapping(value = {"/registratie"}, method = RequestMethod.GET)
    public String addUser(ModelMap model) {

        // verzamelen gegevens voor het login venster
        return "registratie"; // JSP Pagina pointer
    }
}
