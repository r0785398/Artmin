/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.service;

import artmin.dao.TodoDao;
import artmin.model.Todo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rei
 */
@Service("todoService")
@Transactional
public class TodoService {

    @Autowired
    private TodoDao dao;

    // zoeken van todo op basis van ID
    public Todo findById(Long id) {
        return dao.findById(id);
    }

    // Bewaren van todo
    public void saveTodo(Todo todo) {
        dao.saveTodo(todo);
    }

    // bijwerken van bestaande todo
    public void updateTodo(Todo todo) {
        Todo entity = dao.findById(todo.getId());
        if (entity != null) {
            entity.setEventID(todo.getEventID());
            entity.setSortNumber(todo.getSortNumber());
            entity.setName(todo.getName());
            entity.setDescription(todo.getDescription());
            entity.setAttachmentFilePath(todo.getAttachmentFilePath());
            entity.setAck(todo.isAck());
        }
    }

    // verwijderen van todo
    public void deleteTodoById(Long id) {
        dao.deleteTodoById(id);
    }

    // verwijderen van Todo's
    public void deleteAllTodo(Long eventID) {
        // Zoek alle Todo's met het aangegeven event ID
        List<Todo> lstToDelete = this.findAllTodos(eventID);

        for (Todo tmp : lstToDelete) {
            this.deleteTodoById(tmp.getId());
        }
    }

    // zoeken van alle todos
    public List<Todo> findAllTodos(Long eventID) {
        return dao.findAllTodos(eventID);
    }
}
