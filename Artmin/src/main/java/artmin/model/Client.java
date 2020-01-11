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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Rei
 */
@Entity
@Table(name = "Clients")
public class Client implements Serializable {

    //    Attributen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userID")
    private Long userID;

    @Transient
    private User user;

    @Column(name = "artistID")
    private Long artistID;

    @Transient
    private Artist artist;

    @NotEmpty
    @Size(min=2,max=50)
    @Column(name = "name", nullable = false)
    private String name;
    
    @Size(min=2,max=50)
    @Column(name = "street", nullable = true)
    private String street;
    
    @Size(max=25)
    @Column(name = "nrBus", nullable = true)
    private String nrBus;
    
    @Size(min=4,max=12)
    @Column(name = "postCode", nullable = true)
    private String postCode;
    
    @Size(min=2,max=50)
    @Column(name = "city", nullable = true)
    private String city;
    
    @Size(min=2,max=50)
    @Column(name = "country", nullable = true)
    private String country;
    
    @Size(min=2,max=25)
    @Column(name = "phone", nullable = true)
    private String phone;
    
    @Email
    @Size(min=2,max=100)
    @Column(name = "email", nullable = true)
    private String email;
    
    @Size(min=2,max=25)
    @Column(name = "vat", nullable = true)
    private String vat;
    
    @Column(name = "ack", nullable = true)
    private boolean ack;

//    Properties
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public boolean isAck() {
        return ack;
    }

    public void setAck(boolean ack) {
        this.ack = ack;
    }

//    Methodes
    public boolean isComplete() {
        // check of alle velden zijn ingevuld ==> set ACK
        if (name == null || name.isEmpty()) {
            return false;
        }

        if (street == null || street.isEmpty()) {
            return false;
        }

        if (nrBus == null || nrBus.isEmpty()) {
            return false;
        }

        if (postCode == null || postCode.isEmpty()) {
            return false;
        }

        if (city == null || city.isEmpty()) {
            return false;
        }

        if (country == null || country.isEmpty()) {
            return false;
        }

        if (email == null || email.isEmpty()) {
            return false;
        }

        this.setAck(true);

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        if (!(obj instanceof Client)) {
            return false;
        }
        Client other = (Client) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + "]";
    }
}
