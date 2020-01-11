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
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rei
 */
@Repository("todoDao")
public class TodoDao extends AbstractDao<Long, Todo> {

    public Todo findById(long id) {
        return getByKey(id);
    }

    public void saveTodo(Todo todo) {
        persist(todo);
    }

    public void deleteTodoById(Long id) {
        Query query = getSession().createSQLQuery("delete from Todos where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Todo> findAllTodos(Long eventID) {
        // Enkel de notities ophalen die bij één event horen
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("eventID", eventID));

        return (List<Todo>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Todo> findAllTodosAck(Long eventID) {
        // Enkel de notities ophalen die bij één event horen
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("eventID", eventID));
        criteria.add(Restrictions.eq("ack", true));

        return (List<Todo>) criteria.list();
    }
}
