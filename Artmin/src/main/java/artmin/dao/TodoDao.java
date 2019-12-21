/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.Todo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rei
 */
@Repository("todoDao")
public class TodoDao extends AbstractDao<Long, Todo>{
    
    public Todo findById(long id){
        return getByKey(id);
    }
    
    public void saveTodo(Todo todo) {
        persist(todo);
    }

    public void deleteTodoById(Long id) {
        Query query = getSession().createSQLQuery("delete from todo where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    public List<Todo> findAllTodos() {
        Criteria criteria = createEntityCriteria();
        return (List<Todo>) criteria.list();
    }
}
