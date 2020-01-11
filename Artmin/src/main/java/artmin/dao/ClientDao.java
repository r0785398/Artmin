/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.Client;
import artmin.model.EventLocation;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rei
 */
@Repository("clientDao")
public class ClientDao extends AbstractDao<Long, Client> {

    public Client findById(Long id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Client> findSingleClient(Long userID, String name) {

        // van één artiest en dezelfde naam
        Criteria criteriaevent = createEntityCriteria();
        criteriaevent.add(Restrictions.eq("userID", userID));
        criteriaevent.add(Restrictions.eq("name", name));

        return (List<Client>) criteriaevent.list();
    }

    public void saveClient(Client client) {
        persist(client);
    }

    public void deleteClientById(Long id) {
        Query query = getSession().createSQLQuery("delete from Clients where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Client> findAllClients() {
        Criteria criteria = createEntityCriteria();
        return (List<Client>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Client> finAllMyClients(Long userID) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userID", userID));

        return (List<Client>) criteria.list();
    }
}
