/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.service;

import artmin.dao.PaymentDao;
import artmin.model.Payment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rei
 */
@Service("paymentService")
@Transactional
public class PaymentService {

    @Autowired
    private PaymentDao dao;

    // zoeken van payment op basis van ID
    public Payment findById(Long id) {
        return dao.findById(id);
    }

    // Bewaren van payment
    public void savePayment(Payment payment) {
        dao.savePayment(payment);
    }

    // bijwerken van bestaande payment
    public void updatePayment(Payment payment) {
        Payment entity = dao.findById(payment.getId());
        if (entity != null) {
            entity.setEventID(payment.getEventID());
            entity.setModeTimeStamp(payment.getModeTimeStamp());
            entity.setName(payment.getName());
            entity.setDescription(payment.getDescription());
            entity.setPrice(payment.getPrice());
            entity.setAck(payment.isAck());
        }
    }

    // verwijderen van payment
    public void deletePaymentById(Long id) {
        dao.deletePaymentById(id);
    }

    // verwijderen van payment
    public void deleteAllPayments(Long eventID) {
        // Zoek alle payments met het aangegeven event ID
        List<Payment> lstToDelete = this.findAllpayments(eventID);

        for (Payment tmp : lstToDelete) {
            this.deletePaymentById(tmp.getId());
        }
    }

    // zoeken van alle payments
    public List<Payment> findAllpayments(Long eventID) {
        return dao.findAllPayments(eventID);
    }

    // zoeken van alle payments
    public List<Payment> findAllPaymentsAck(Long eventID) {
        return dao.findAllPaymentsAck(eventID);
    }
}
