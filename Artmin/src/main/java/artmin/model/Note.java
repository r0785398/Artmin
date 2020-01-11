/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Rei
 */
@Entity
@Table(name = "Notes")
public class Note implements Serializable {
    //    Attributen

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "eventID", nullable = false, insertable = false, updatable = false)
    private Long eventID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventID") // Object link naar Database ID
    private Event event;

    @Column(name = "modUserID", nullable = false, insertable = false, updatable = false)
    private Long modUserID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modUserID") // Object link naar Database ID
    private User modUsers;

    @Column(name = "modeTimeStamp", nullable = false)
    private Date modeTimeStamp;

    @Column(name = "note", nullable = true)
    private String note;

//    Properties
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventID() {
        return eventID;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }



    public Long getModUserID() {
        return modUserID;
    }

    public void setModUserID(Long modUserID) {
        this.modUserID = modUserID;
    }

    public User getModUsers() {
        return modUsers;
    }

    public void setModUsers(User modUsers) {
        this.modUsers = modUsers;
    }

    public Date getModeTimeStamp() {
        return modeTimeStamp;
    }

    public void setModeTimeStamp(Date modeTimeStamp) {
        this.modeTimeStamp = modeTimeStamp;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

//    Methodes
    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((modeTimeStamp == null) ? 0 : modeTimeStamp.hashCode());
        return (int) result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Note)) {
            return false;
        }
        Note other = (Note) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (modeTimeStamp == null) {
            if (other.modeTimeStamp != null) {
                return false;
            }
        } else if (!modeTimeStamp.equals(other.modeTimeStamp)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Note [id=" + id + ", note=" + note + "]";
    }
}
