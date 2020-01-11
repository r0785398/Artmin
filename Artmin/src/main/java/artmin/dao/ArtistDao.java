/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.Artist;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("artistDao")
public class ArtistDao extends AbstractDao<Long, Artist> {

    public Artist findById(Long id) {
        return getByKey(id);
    }

    public void saveArtist(Artist artist) {
        persist(artist);
    }

    public void deleteArtistById(Long id) {
        Query query = getSession().createSQLQuery("delete from Artists where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Artist> findAllArtists() {
        Criteria criteria = createEntityCriteria();

        return (List<Artist>) criteria.list();
    }
}
