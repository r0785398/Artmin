/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.EventType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rei
 */
@Repository("eventTypeDao")
public class EventTypeDao extends AbstractDao<Long, EventType>{
    
    public EventType findById(long id){
        return getByKey(id);
    }
    
    public void saveEventType(EventType eventType) {
        persist(eventType);
    }

    public void deleteEventTypeById(Long id) {
        Query query = getSession().createSQLQuery("delete from eventType where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    public List<EventType> findAllEventTypes() {
        Criteria criteria = createEntityCriteria();
        return (List<EventType>) criteria.list();
    }
}
