/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

/**
 *
 * @author Rei
 */
@Entity
@Table(name="Artists")
public class Artist {
//    Attributen
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    @Size(min=2, max=50)
    @Column(name = "name", nullable = false)
    private String name;
    
    @Size(max = 100)
    @Column(name = "description", nullable = true)
    private String description;
    
    @URL
    @Size(max=255)
    @Column(name = "logoUrl", nullable = true)
    private String logoUrl;
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="artistID")
    private Set<UserArtist> artists;
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="artistID")
    private Set<Event> events;
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="artistID")
    private Set<EventLocation> eventLocations;
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="artistID")
    private Set<Client> clients;
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="artistID")
    private Set<EventType> eventTypes;
    
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Set<UserArtist> getArtists() {
        return artists;
    }

    public void setArtists(Set<UserArtist> artists) {
        this.artists = artists;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<EventLocation> getEventLocations() {
        return eventLocations;
    }

    public void setEventLocations(Set<EventLocation> eventLocations) {
        this.eventLocations = eventLocations;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<EventType> getEventTypes() {
        return eventTypes;
    }

//    Properties
    public void setEventTypes(Set<EventType> eventTypes) {
        this.eventTypes = eventTypes;
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
        if (!(obj instanceof Artist))
            return false;
        Artist other = (Artist) obj;
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
        return "Artist [id=" + id + ", name=" + name + "]";
    }
}
