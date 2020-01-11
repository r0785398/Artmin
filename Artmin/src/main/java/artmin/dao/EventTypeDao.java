/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.Event;
import artmin.model.EventType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rei
 */
@Repository("eventTypeDao")
public class EventTypeDao extends AbstractDao<Long, EventType> {

    public EventType findById(Long id) {
        return getByKey(id);
    }
    
    @SuppressWarnings("unchecked")
    public List<EventType> findSingleEventType(Long artistID, String name) {
        // Enkel ophalen van events van één bepaald artiest waarbij de naam overeenkomt

        Criteria criteriaevent = createEntityCriteria();
        criteriaevent.add(Restrictions.eq("artistID", artistID));
        criteriaevent.add(Restrictions.eq("name", name));

        return (List<EventType>) criteriaevent.list();
    }

    public void saveEventType(EventType eventType) {
        persist(eventType);
    }

    public void deleteEventTypeById(Long id) {
        Query query = getSession().createSQLQuery("delete from EventTypes where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<EventType> findAllEventTypes() {
        Criteria criteria = createEntityCriteria();
        return (List<EventType>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<EventType> findArtistTypes(Long artistID) {
        // Enkel ophalen van events van één bepaald artiest

        Criteria criteriaevent = createEntityCriteria();
        criteriaevent.add(Restrictions.eq("artistID", artistID));

        return (List<EventType>) criteriaevent.list();
    }
    
    
}
