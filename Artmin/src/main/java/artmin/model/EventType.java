/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Rei
 */

@Entity
@Table(name="EventTypes")
public class EventType implements Serializable {
    //    Attributen
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "artistID", nullable = false, insertable = false, updatable = false)
    private Long artistID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artistID") // Object link naar Database ID
    private Artist artist;
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="eventTypeID")
    private Set<TodoTemplate> todoTemplates;

//    Properties

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArtistID() {
        return artistID;
    }

    public void setArtistID(Long artistID) {
        this.artistID = artistID;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Set<TodoTemplate> getTodoTemplates() {
        return todoTemplates;
    }

    public void setTodoTemplates(Set<TodoTemplate> todoTemplates) {
        this.todoTemplates = todoTemplates;
    }

    

//    Methodes
    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return (int)result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof EventType))
            return false;
        EventType other = (EventType) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "EventType [id=" + id + ", name=" + name + "]";
    }
}
