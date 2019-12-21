/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Rei
 */
@Entity
@Table(name="UsersArtists", uniqueConstraints = { @UniqueConstraint( columnNames = { "userID", "artistID" } ) })
public class UserArtist implements Serializable {
    
    
    @EmbeddedId
    private UserArtistFK userArtistID;
    
//    @Id
    @Column(name = "userID", nullable=false, insertable = false, updatable = false)
    private Long userID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    
    @Column(name = "artistID", nullable=false, insertable = false, updatable = false)
    private Long artistID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;
    
    @NotEmpty
    @Column(name = "role", nullable = false)
    private int role;
    
//    Properties

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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public UserArtistFK getUserArtistID() {
        return userArtistID;
    }

    public void setUserArtistID(UserArtistFK userArtistID) {
        this.userArtistID = userArtistID;
    }

    
//    Methodes
    
    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + userID + artistID;
        return (int)result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserArtist))
            return false;
        UserArtist other = (UserArtist) obj;
        if (userID != other.getUserID() || artistID != other.getArtistID())
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "UserArtist [userid=" + userID + ", artistid=" + artistID +"]";
    }
    
}
