/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.service;

import artmin.dao.UserArtistDao;
import artmin.model.UserArtist;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author m0317426
 */

@Service("userArtistService")
@Transactional

public class UserArtistService {
 
    @Autowired
    private UserArtistDao dao;
     
    // zoeken van UserArtists op basis van ID
    public UserArtist findById(Long userId, Long artistId) {
        return dao.findById(userId, artistId);
    }
 
    // Bewaren van UserArtists
    public void saveUserArtist(UserArtist userArtist) {
        dao.saveUserArtist(userArtist);
    }
 
    // bijwerken van bestaande UserArtists
    public void updateUserArtist(UserArtist userArtist) {
        UserArtist entity = dao.findById(userArtist.getUserID(),userArtist.getArtistID());
        if(entity!=null){
            entity.setRole(userArtist.getRole());
        }
    }
 
    // verwijderen van UserArtists
    public void deleteUserArtistById(Long userId, Long artistId) {
        dao.deleteUserArtistByUserIdAndArtistId(userId, artistId);
    }
     
    // zoeken van alle UserArtists
    public List<UserArtist> findAllUserArtists() {
        return dao.findAllUserArtists();
    }
    // zoeken van alle UserArtists met role
    public List<UserArtist> findAllUserArtistsByUserdIdAndRole(Long userId, Long artistId) {
        return dao.findAllUserArtistsByUserdIdAndRole(userId, artistId);
    }

}
