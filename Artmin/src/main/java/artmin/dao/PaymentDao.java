/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.Payment;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
        Query query = getSession().createSQLQuery("delete from payment where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    public List<Payment> findAllPayments() {
        Criteria criteria = createEntityCriteria();
        return (List<Payment>) criteria.list();
    }
}
