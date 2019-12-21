/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.dao;

import artmin.model.Company;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rei
 */
@Repository("companyDao")
public class CompanyDao extends AbstractDao<Long, Company>{
    
    public Company findById(long id){
        return getByKey(id);
    }
    
    public void saveCompany(Company company) {
        persist(company);
    }

    public void deleteCompanyById(Long id) {
        Query query = getSession().createSQLQuery("delete from company where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    public List<Company> findAllCompanies() {
        Criteria criteria = createEntityCriteria();
        return (List<Company>) criteria.list();
    }
}
