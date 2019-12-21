package artmin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import artmin.model.Client;
import artmin.service.ClientService;


@Controller
@RequestMapping("/client")

public class ClientController {
    
      
    @Autowired
    ClientService clientService;
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newClient(ModelMap model) {
        Client client = new Client();
        model.addAttribute("client", client);
        model.addAttribute("edit", false);
        return "clientregistration"; //view r-team
    }
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveClient(Client client, BindingResult result, ModelMap model) {
        
        //First check if user already excists
        List<Client> lstClients = clientService.findAllClients();
        
        for( Client clients : lstClients){
            String clientOutOfList = clients.getName();
            String clientNewinList = clients.getName();
             //&& artists.getDescription() == artist.getDescription() 
            if (clientOutOfList.equals(clientNewinList)){
                model.addAttribute("message", "Clientalready excists");
                return "clientregistration";
            }
        }
        
        //Save user to DB
        clientService.saveClient(client);
        
        //Redirect user to success page
        model.addAttribute("success", "Client" + client.getName() + " registered successfully");
        return "clientsucces"; //view r-team
    }
    
    @RequestMapping(value = {"/edit-{id}-artist"}, method = RequestMethod.GET)
    public String editClient(@PathVariable Long id, ModelMap model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        model.addAttribute("edit", true);
        return "clientregistration";
    }
    
    @RequestMapping(value = {"/edit-{id}-artist"}, method = RequestMethod.POST)
    public String updateClient(Client client, BindingResult result, ModelMap model, @PathVariable Long id){
        
        clientService.updateClient(client);
        
        model.addAttribute("success", "Client" + client.getName() + " registered successfully");
        return "clientsucces";
    }
    
    @RequestMapping(value = {"/delete-{id}-artist"}, method=RequestMethod.GET)
    public String deleteClient(@PathVariable Long id, ModelMap model){
        clientService.deleteClientById(id);
        model.addAttribute("success", "Client verwijderd");
        return "clientsucces";
    }
    
    @RequestMapping(value = {"", "/list"}, method = RequestMethod.GET)
    public String listClient(ModelMap model) {
        List<Client> lstClients = clientService.findAllClients(); // ophalen gegevens uit database
        model.addAttribute("clients", lstClients); //Attribute aan "pagina" model toevoegen naam: users, data= List<Users> met naam lstUsers
        return "clientlist"; // JSP Pagina pointer
    }

}
