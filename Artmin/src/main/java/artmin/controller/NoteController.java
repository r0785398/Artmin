package artmin.controller;

import artmin.model.Artist;
import artmin.model.Event;
import artmin.model.Note;
import artmin.service.ArtistService;
import artmin.service.EventService;
import artmin.service.NoteService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    ArtistService artistService;

    @Autowired
    NoteService noteService;

    @Autowired
    EventService eventService;

    // NEW GET
    @RequestMapping(value = {"/new-{eventID}"}, method = RequestMethod.GET)
    public String newNote(@PathVariable Long eventID, ModelMap model) {

        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);

        // Init object
        Note note = new Note();
        model.addAttribute("note", note);

        // Set new
        model.addAttribute("edit", false);
        return "notesnew"; // view
    }

    // NEW POST
    @RequestMapping(value = {"/new-{eventID}"}, method = RequestMethod.POST)
    public String save(Note note, @PathVariable Long eventID, BindingResult result, ModelMap model) {

        // fill event
        note.setEvent(eventService.findById(note.getEventID()));

        //Save to DB
        noteService.saveNote(note);

        // terug naar overzicht
        return list(eventID, model);
    }

    // UPDATE GET
    @RequestMapping(value = {"/edit-{noteID}-{eventID}"}, method = RequestMethod.GET)
    public String edit(@PathVariable Long noteID, @PathVariable Long eventID, ModelMap model) {
        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);

        // Init object
        Note note = noteService.findById(noteID);
        model.addAttribute("note", note);

        // Set new
        model.addAttribute("edit", true);
        return "notesnew"; // view
    }

    // UPDATE POST
    @RequestMapping(value = {"/edit-{noteID}-{eventID}"}, method = RequestMethod.POST)
    public String update(Note note, @PathVariable Long noteID, @PathVariable Long eventID, BindingResult result, ModelMap model) {
        // fill event
        note.setEvent(eventService.findById(note.getEventID()));

        //Save to DB
        noteService.updateNote(note);

        // terug naar overzicht
        return list(eventID, model);
    }

    @RequestMapping(value = {"/delete-{noteID}-{eventID}"}, method = RequestMethod.GET)
    public String delete(@PathVariable Long noteID, @PathVariable Long eventID, ModelMap model) {

        // Delet in DB
        noteService.deleteNoteById(noteID);

        // terug naar overzicht
        return list(eventID, model);
    }

    @RequestMapping(value = {"all-{eventID}",}, method = RequestMethod.GET)
    public String list(@PathVariable Long eventID, ModelMap model) {
        // get list
        List<Note> lstNotes = noteService.findAllNotes(eventID);
        model.addAttribute("notes", lstNotes);

        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);
        
        return "notesselect"; // naar overzicht
    }
}
