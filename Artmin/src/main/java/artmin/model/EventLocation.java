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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Rei
 */
@Entity(name="  EventLocation")
@Table(name="EventLocations")
public class EventLocation {
    
    //    Attributen
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "userID", nullable=false)
    private Long userID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    
    @Column(name = "artistID", nullable=false)
    private Long artistID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;
    
    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "manager", nullable = true)
    private String manager;
    
    @Column(name = "street", nullable = true)
    private String street;
    
    @Column(name = "nrBus", nullable = true)
    private String nrBus;
    
    @Column(name = "postCode", nullable = true)
    private String postCode;
    
    @Column(name = "city", nullable = true)
    private String city;
    
    @Column(name = "country", nullable = true)
    private String country;
    
    @Column(name = "phone", nullable = true)
    private String phone;
    
    @Column(name = "vat", nullable = true)
    private String vat;
    
    @Column(name = "email", nullable = true)
    private String email;
    
    @Column(name = "ack", nullable = true)
    private boolean ack;
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="locationID")
    private Set<Event> events;
    
//    Properties

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNrBus() {
        return nrBus;
    }

    public void setNrBus(String nrBus) {
        this.nrBus = nrBus;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAck() {
        return ack;
    }

    public void setAck(boolean ack) {
        this.ack = ack;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    

//    Methodes
    
     @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + id;
        return (int)result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof EventLocation))
            return false;
        EventLocation other = (EventLocation) obj;
        if (id != other.getId())
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "EventLocation [id=" + id + ", name=" + name + "]";
    }
}