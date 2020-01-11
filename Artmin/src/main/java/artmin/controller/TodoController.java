package artmin.controller;

import artmin.model.Artist;
import artmin.model.Todo;
import artmin.model.Event;
import artmin.model.Note;
import artmin.service.ArtistService;
import artmin.service.EventService;
import artmin.service.NoteService;
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
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    ArtistService artistService;

    @Autowired
    NoteService noteService;

    @Autowired
    TodoService todoService;

    @Autowired
    EventService eventService;

    // NEW GET
    @RequestMapping(value = {"/new-{eventID}"}, method = RequestMethod.GET)
    public String newItem(@PathVariable Long eventID, ModelMap model) {

        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);

        // Init object
        Todo todo = new Todo();
        model.addAttribute("todo", todo);

        // Set new
        model.addAttribute("edit", false);
        return "todosnew"; // view
    }

    // NEW POST
    @RequestMapping(value = {"/new-{eventID}"}, method = RequestMethod.POST)
    public String saveItem(Todo todo, @PathVariable Long eventID, BindingResult result, ModelMap model) {

        // fill event
        todo.setEvent(eventService.findById(todo.getEventID()));

        //Save to DB
        todoService.saveTodo(todo);

        // terug naar overzicht
        return listItems(eventID, model);
    }

    // UPDATE GET
    @RequestMapping(value = {"/edit-{todoID}-{eventID}"}, method = RequestMethod.GET)
    public String editItem(@PathVariable Long todoID, @PathVariable Long eventID, ModelMap model) {
        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);

        // Init object
        Todo todo = todoService.findById(todoID);
        model.addAttribute("todo", todo);

        // Set new
        model.addAttribute("edit", true);
        return "todosnew"; // view
    }

    // UPDATE POST
    @RequestMapping(value = {"/edit-{todoID}-{eventID}"}, method = RequestMethod.POST)
    public String updateItem(Todo todo, @PathVariable Long todoID, @PathVariable Long eventID, BindingResult result, ModelMap model) {
        // fill event
        todo.setEvent(eventService.findById(todo.getEventID()));

        //Save to DB
        todoService.updateTodo(todo);

        // Attach event
        model.addAttribute("event", todo.getEvent());

        // terug naar overzicht
        return listItems(eventID, model);
    }

    // ACK UPDATE
    @RequestMapping(value = {"/ack-{todoID}-{eventID}"}, method = RequestMethod.GET)
    public String Ack(@PathVariable Long todoID, @PathVariable Long eventID, ModelMap model) {
        Todo todo = todoService.findById(todoID);

        if (todo.isAck()) {
            todo.setAck(false);
        } else {
            todo.setAck(true);
        }

        //Save to DB
        todoService.updateTodo(todo);
        
         return listItems(eventID, model); 
    }

    @RequestMapping(value = {"/delete-{todoID}-{eventID}"}, method = RequestMethod.GET)
    public String deleteItem(@PathVariable Long todoID, @PathVariable Long eventID, ModelMap model) {

        // Delet in DB
        todoService.deleteTodoById(todoID);

        // terug naar overzicht
        return listItems(eventID, model);
    }

    @RequestMapping(value = {"all-{eventID}",}, method = RequestMethod.GET)
    public String listItems(@PathVariable Long eventID, ModelMap model) {
        // get list
        List<Todo> lst = todoService.findAllTodos(eventID);
        model.addAttribute("todos", lst);

        // Get Event object
        Event evnt = eventService.findById(eventID);
        model.addAttribute("event", evnt);

        return "todosall"; // naar overzicht
    }
}
