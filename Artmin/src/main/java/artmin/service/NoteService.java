/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.service;

import artmin.dao.NoteDao;
import artmin.model.Event;
import artmin.model.Note;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rei
 */
@Service("noteService")
@Transactional
public class NoteService {

    @Autowired
    private NoteDao dao;

    // zoeken van note op basis van ID
    public Note findById(Long id) {
        return dao.findById(id);
    }

    // Bewaren van note
    public void saveNote(Note note) {
        dao.saveNote(note);
    }

    // bijwerken van bestaande note
    public void updateNote(Note note) {
        Note entity = dao.findById(note.getId());
        if (entity != null) {
            entity.setEventID(note.getEventID());
            entity.setModUserID(note.getModUserID());
            entity.setModeTimeStamp(note.getModeTimeStamp());
            entity.setNote(note.getNote());
        }
    }

    // verwijderen van note
    public void deleteNoteById(Long id) {
        dao.deleteNoteById(id);
    }

    // verwijderen van notes
    public void deleteAllNotes(Long eventID) {
        // Zoek alle Notes met het aangegeven event ID
        List<Note> lstToDelete = this.findAllNotes(eventID);

        for (Note tmp : lstToDelete) {
            this.deleteNoteById(tmp.getId());
        }
    }

    // zoeken van alle notes
    public List<Note> findAllNotes(Long eventID) {
        return dao.findAllNotes(eventID);
    }
}
