/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.service;

import artmin.dao.TodoTemplateDao;
import artmin.model.TodoTemplate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rei
 */

@Service("todoTemplateService")
@Transactional
public class TodoTemplateService {
    
    @Autowired
    private TodoTemplateDao dao;
     
    // zoeken van todoTemplate op basis van ID
    public TodoTemplate findById(Long id) {
        return dao.findById(id);
    }
 
    // Bewaren van todoTemplate
    public void saveTodoTemplate(TodoTemplate artist) {
        dao.saveTodoTemplate(artist);
    }
 
    // bijwerken van bestaande todoTemplate
    public void updateTodoTemplate(TodoTemplate todoTemplate) {
        TodoTemplate entity = dao.findById(todoTemplate.getId());
        if(entity!=null){
            entity.setEventTypeID(todoTemplate.getEventTypeID());
            entity.setSortNumber(todoTemplate.getSortNumber());
            entity.setName(todoTemplate.getName());
        }
    }
 
    // verwijderen van todoTemplate
    public void deleteTodoTemplateById(Long id) {
        dao.deleteTodoTemplateById(id);
    }
     
    // zoeken van alle todoTemplates
    public List<TodoTemplate> findAllTodoTemplates() {
        return dao.findAllTodoTemplates();
    }
}
