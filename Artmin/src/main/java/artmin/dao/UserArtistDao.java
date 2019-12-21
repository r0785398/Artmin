package artmin.dao;

import artmin.model.Artist;
import artmin.model.UserArtist;
import artmin.model.UserArtistFK;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userArtistDao")  
public class UserArtistDao extends AbstractDao<UserArtistFK,UserArtist>{

    public UserArtist findById(long userId, long artistId){
        UserArtistFK userArtistID = new UserArtistFK(userId, artistId);
        return (UserArtist)getByKey(userArtistID);
    }
 
    public void saveUserArtist(UserArtist userArtist) {
        persist(userArtist);
    }
    
    public void deleteUserArtistByUserIdAndArtistId(long userId, long artistId) {
        UserArtistFK userArtistID = new UserArtistFK(userId,artistId);
        delete(getByKey(userArtistID));
//        Query query = getSession().createSQLQuery("DELETE FROM UsersArtist WHERE userID = :uid AND artistID = :aid");
//        query.setLong("uid", userId);
//        query.setLong("aid", artistId);
//        query.executeUpdate();
    }
        
    @SuppressWarnings("unchecked")
    public List<UserArtist> findAllUserArtists() {
        Criteria criteria = createEntityCriteria();
        return (List<UserArtist>) criteria.list();
    }
    
    /*
    Indien een gebruiker eigenaar is van een artiest, moeten de artiesten eveneens verwijderd worden.
    */
    @SuppressWarnings("unchecked")
    public List<UserArtist> findAllUserArtistsByUserdIdAndRole(long userId, long role){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userID", userId));
        criteria.add(Restrictions.eq("role", role));
        return (List<UserArtist>) criteria.list();
    }
}
