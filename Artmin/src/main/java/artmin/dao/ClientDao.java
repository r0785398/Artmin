/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.Client;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rei
 */

@Repository("clientDao")
public class ClientDao extends AbstractDao<Long, Client>{
    public Client findById(long id){
        return getByKey(id);
    }
    
    public void saveClient(Client client) {
        persist(client);
    }

    public void deleteClientById(Long id) {
        Query query = getSession().createSQLQuery("delete from client where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    public List<Client> findAllClients() {
        Criteria criteria = createEntityCriteria();
        return (List<Client>) criteria.list();
    }
}
