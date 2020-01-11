/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.EventLocation;
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
@Repository("eventLocationDao")
public class EventLocationDao extends AbstractDao<Long, EventLocation> {

    public EventLocation findById(Long id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<EventLocation> findSingleEventType(Long artistID, String name) {
        // van één artiest en dezelfde naam

        Criteria criteriaevent = createEntityCriteria();
        criteriaevent.add(Restrictions.eq("artistID", artistID));
        criteriaevent.add(Restrictions.eq("name", name));

        return (List<EventLocation>) criteriaevent.list();
    }
    
    public void saveEventLocation(EventLocation eventLocation) {
        persist(eventLocation);
    }

    public void deleteEventLocationById(Long id) {
        Query query = getSession().createSQLQuery("delete from EventLocations where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<EventLocation> findAllEventLocations() {
        Criteria criteria = createEntityCriteria();
        return (List<EventLocation>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<EventLocation> findAllMyLocations(Long artistID) {       
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("artistID", artistID));
        
        
        return (List<EventLocation>) criteria.list();
    }
}
