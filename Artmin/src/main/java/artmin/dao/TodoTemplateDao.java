/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.TodoTemplate;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Rei
 */
@Repository("todoTemplateDao")
public class TodoTemplateDao extends AbstractDao<Long, TodoTemplate>{
    
    public TodoTemplate findById(long id){
        return getByKey(id);
    }
    
    public void saveTodoTemplate(TodoTemplate todoTemplate) {
        persist(todoTemplate);
    }

    public void deleteTodoTemplateById(Long id) {
        Query query = getSession().createSQLQuery("delete from todoTemplate where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    public List<TodoTemplate> findAllTodoTemplates() {
        Criteria criteria = createEntityCriteria();
        return (List<TodoTemplate>) criteria.list();
    }
}
