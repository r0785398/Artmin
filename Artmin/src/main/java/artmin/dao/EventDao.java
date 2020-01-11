/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.Event;
import artmin.model.EventType;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rei
 */
@Repository("eventDao")
public class EventDao extends AbstractDao<Long, Event> {

    public Event findById(Long id) {
        return getByKey(id);
    }

    public void saveEvent(Event event) {
        persist(event);
    }

    public void deleteEventById(Long id) {
        Query query = getSession().createSQLQuery("delete from events where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Event> findUpcommingEvents(Long artistID) {
        // Enkel ophalen van events van één bepaald artiest

        Date now = new Date(); // = NU - vandaag

        Criteria criteriaevent = createEntityCriteria();
        // FIlter oop events van de gekozen artiest
        criteriaevent.add(Restrictions.eq("artistID", artistID));

        // Filter enkel actieve events = NOT cancelled
        criteriaevent.add(Restrictions.eq("canceledAck", false));

        // laat enkel de events zien van vandaag en komende
        criteriaevent.add(Restrictions.ge("dateCalendar", now));

        List<Event> eventResult = criteriaevent.list();

        Collections.sort(eventResult);

        return (List<Event>) eventResult;
    }

    @SuppressWarnings("unchecked")
    public List<Event> findAllEvents(Long artistID) {
        // Enkel ophalen van events van één bepaald artiest

        Criteria criteriaevent = createEntityCriteria();
        // FIlter oop events van de gekozen artiest
        criteriaevent.add(Restrictions.eq("artistID", artistID));

        return (List<Event>) criteriaevent.list();
    }

    @SuppressWarnings("unchecked")
    public List<Event> findAllEventsNotOK(Long artistID) {
        // Enkel ophalen van events van één bepaald artiest

        Criteria criteriaevent = createEntityCriteria();
        // FIlter oop events van de gekozen artiest
        criteriaevent.add(Restrictions.eq("artistID", artistID));

        criteriaevent.add(Restrictions.eq("todoAck", false));
        criteriaevent.add(Restrictions.eq("dateAck", false));
        criteriaevent.add(Restrictions.eq("confirmedAck", false));
        criteriaevent.add(Restrictions.eq("locationAck", false));
        criteriaevent.add(Restrictions.eq("clientAck", false));
        criteriaevent.add(Restrictions.eq("crowdAck", false));
        criteriaevent.add(Restrictions.eq("canceledAck", false));

        return (List<Event>) criteriaevent.list();
    }

    @SuppressWarnings("unchecked")
    public List<Event> findEventByName(Long artistID, String name) {
        // Enkel ophalen van events van één bepaald artiest

        Criteria criteriaevent = createEntityCriteria();
        // FIlter oop events van de gekozen artiest
        criteriaevent.add(Restrictions.eq("artistID", artistID));
        criteriaevent.add(Restrictions.eq("name", name));

        criteriaevent.add(Restrictions.eq("todoAck", false));
        criteriaevent.add(Restrictions.eq("dateAck", false));
        criteriaevent.add(Restrictions.eq("confirmedAck", false));
        criteriaevent.add(Restrictions.eq("clientAck", false));
        criteriaevent.add(Restrictions.eq("crowdAck", false));
        criteriaevent.add(Restrictions.eq("canceledAck", false));

        return (List<Event>) criteriaevent.list();
    }

    @SuppressWarnings("unchecked")
    public List<Event> findEventsWithType(EventType eventTypeID) {
        // Enkel ophalen van events van één bepaald type

        Criteria criteriaevent = createEntityCriteria();
        criteriaevent.add(Restrictions.eq("eventType", eventTypeID));

        return (List<Event>) criteriaevent.list();
    }

    @SuppressWarnings("unchecked")
    public List<Event> findEventsWithLocation(Long locationID) {
        // Enkel ophalen van events van één bepaald locatie

        Criteria criteriaevent = createEntityCriteria();
        criteriaevent.add(Restrictions.eq("locationID", locationID));

        return (List<Event>) criteriaevent.list();
    }

    @SuppressWarnings("unchecked")
    public List<Event> findEventsWithClient(Long clientID) {
        // Enkel ophalen van events van één bepaald locatie

        Criteria criteriaevent = createEntityCriteria();
        criteriaevent.add(Restrictions.eq("clientID", clientID));

        return (List<Event>) criteriaevent.list();
    }
}
