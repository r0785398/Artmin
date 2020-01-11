/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.Event;
import artmin.model.Note;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rei
 */
@Repository("noteDao")
public class NoteDao extends AbstractDao<Long, Note>{
    
    public Note findById(long id){
        return getByKey(id);
    }
    
    public void saveNote(Note note) {
        persist(note);
    }

    public void deleteNoteById(Long id) {
        Query query = getSession().createSQLQuery("delete from Notes where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    public List<Note> findAllNotes(Long eventID) {
        // Enkel de notities ophalen die bij één event horen
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("eventID", eventID));
        
        return (List<Note>) criteria.list();
    }  
}
