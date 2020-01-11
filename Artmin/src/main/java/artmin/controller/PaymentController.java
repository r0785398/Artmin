package artmin.controller;

import artmin.model.Artist;
import artmin.model.Todo;
import artmin.model.Event;
import artmin.model.Note;
import artmin.model.Payment;
import artmin.service.ArtistService;
import artmin.service.EventService;
import artmin.service.NoteService;
import artmin.service.PaymentService;
import artmin.service.TodoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    ArtistService artistService;

    @Autowired
    NoteService noteService;

    @Autowired
    TodoService todoService;

    @Autowired
    EventService eventService;

    @Autowired
    PaymentService paymentService;

    // NEW GET
    @RequestMapping(value = {"/new-{eventID}"}, method = RequestMethod.GET)
    public String newItem(@PathVariable Long eventID, ModelMap model) {

        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);

        // Init object
        Payment payment = new Payment();
        model.addAttribute("payment", payment);

        // Set new
        model.addAttribute("edit", false);
        return "paymentsnew"; // view
    }

    // NEW POST
    @RequestMapping(value = {"/new-{eventID}"}, method = RequestMethod.POST)
    public String saveItem(Payment payment, @PathVariable Long eventID, BindingResult result, ModelMap model) {

        // fill event
        payment.setEvent(eventService.findById(payment.getEventID()));

        //Save to DB
        paymentService.savePayment(payment);

        // terug naar overzicht
        return listItems(eventID, model);
    }

    // UPDATE GET
    @RequestMapping(value = {"/edit-{paymentID}-{eventID}"}, method = RequestMethod.GET)
    public String editItem(@PathVariable Long paymentID, @PathVariable Long eventID, ModelMap model) {
        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);

        // Init object
        Payment payment = paymentService.findById(paymentID);
        model.addAttribute("payment", payment);

        // Set new
        model.addAttribute("edit", true);
        return "paymentsnew"; // view
    }

    // UPDATE POST
    @RequestMapping(value = {"/edit-{paymentID}-{eventID}"}, method = RequestMethod.POST)
    public String updateItem(Payment payment, @PathVariable Long paymentID, @PathVariable Long eventID, BindingResult result, ModelMap model) {
        // fill event
        payment.setEvent(eventService.findById(payment.getEventID()));

        //Save to DB
        paymentService.updatePayment(payment);

        // Attach event
        model.addAttribute("event", payment.getEvent());

        // terug naar overzicht
        return listItems(eventID, model);
    }

    // ACK UPDATE
    @RequestMapping(value = {"/ack-{paymentID}-{eventID}"}, method = RequestMethod.GET)
    public String Ack(@PathVariable Long paymentID, @PathVariable Long eventID, ModelMap model) {
        Payment payment = paymentService.findById(paymentID);

        if (payment.isAck()) {
            payment.setAck(false);
        } else {
            payment.setAck(true);
        }

        //Save to DB
        paymentService.updatePayment(payment);

        return listItems(eventID, model);
    }
    
    @RequestMapping(value = {"/delete-{paymentID}-{eventID}"}, method = RequestMethod.GET)
    public String deleteItem(@PathVariable Long paymentID, @PathVariable Long eventID, ModelMap model) {
        // Delet in DB
        paymentService.deletePaymentById(paymentID);

        // terug naar overzicht
        return listItems(eventID, model);
    }

    @RequestMapping(value = {"all-{eventID}",}, method = RequestMethod.GET)
    public String listItems(@PathVariable Long eventID, ModelMap model) {
        // get list
        List<Payment> lst = paymentService.findAllpayments(eventID);
        model.addAttribute("payments", lst);

        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);

        return "paymentsall"; // naar overzicht
    }
}
