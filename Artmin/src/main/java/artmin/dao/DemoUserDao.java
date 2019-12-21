package artmin.dao;

import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import artmin.model.DemoUser;

// implements UserDao

@Repository("demoUserDao")
public class DemoUserDao extends AbstractDao<Integer, DemoUser>  {
    public DemoUser findById(int id) {
        return getByKey(id);
    }
 
    public void saveUser(DemoUser user) {
        persist(user);
    }

    public void deleteUserById(int id) {
        Query query = getSession().createSQLQuery("delete from usertest where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    public List<DemoUser> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<DemoUser>) criteria.list();
    }
}
