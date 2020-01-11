/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.Payment;
import artmin.model.Todo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rei
 */
@Repository("paymentDao")
public class PaymentDao extends AbstractDao<Long, Payment>{
    
    public Payment findById(long id){
        return getByKey(id);
    }
    
    public void savePayment(Payment payment) {
        persist(payment);
    }

    public void deletePaymentById(Long id) {
        Query query = getSession().createSQLQuery("delete from Payments where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    public List<Payment> findAllPayments(Long eventID) {
        // Enkel de payments ophalen die bij één event horen
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("eventID", eventID));

        return (List<Payment>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Payment> findAllPaymentsAck(Long eventID) {
        // Enkel de payments ophalen die bij één event horen
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("eventID", eventID));
        criteria.add(Restrictions.eq("ack", true));

        return (List<Payment>) criteria.list();
    }
}
