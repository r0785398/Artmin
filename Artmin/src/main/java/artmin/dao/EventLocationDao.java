/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.EventLocation;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rei
 */
@Repository("eventLocationDao")
public class EventLocationDao extends AbstractDao<Long, EventLocation>{
    
    public EventLocation findById(long id){
        return getByKey(id);
    }
    
    public void saveEventLocation(EventLocation eventLocation) {
        persist(eventLocation);
    }

    public void deleteEventLocationById(Long id) {
        Query query = getSession().createSQLQuery("delete from eventLocation where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    public List<EventLocation> findAllEventLocations() {
        Criteria criteria = createEntityCriteria();
        return (List<EventLocation>) criteria.list();
    }
}
