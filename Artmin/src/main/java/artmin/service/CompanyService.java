/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.service;

import artmin.dao.CompanyDao;
import artmin.model.Company;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rei
 */
@Service("companyService")
@Transactional
public class CompanyService {
    @Autowired
    private CompanyDao dao;
    
    // zoeken van company op basis van ID
    public Company findById(Long id) {
        return dao.findById(id);
    }
 
    // Bewaren van company
    public void saveCompany(Company company) {
        dao.saveCompany(company);
    }
 
    // bijwerken van bestaande company
    public void updateCompany(Company company) {
        Company entity = dao.findById(company.getId());
        if(entity!=null){
            entity.setName(company.getName());
            entity.setManager(company.getManager());
            entity.setStreet(company.getStreet());
            entity.setNrBus(company.getNrBus());
            entity.setPostCode(company.getPostCode());
            entity.setCity(company.getCity());
            entity.setCountry(company.getCountry());
            entity.setPhone(company.getPhone());
            entity.setVat(company.getVat());
            entity.setEmail(company.getEmail());
            entity.setLogoFilePath(company.getLogoFilePath());
            entity.setBankAccount(company.getBankAccount());
            entity.setVatLegalLine(company.isVatLegalLine());
            entity.setInvoicePreFix(company.getInvoicePreFix());
            entity.setFirstInvoiceNumber(company.getFirstInvoiceNumber());
            entity.setTermsAndConditionsUrl(company.getTermsAndConditionsUrl());
        }
    }
 
    // verwijderen van company
    public void deleteCompanyById(Long id) {
        dao.deleteCompanyById(id);
    }
     
    // zoeken van alle companies
    public List<Company> findAllCompanies() {
        return dao.findAllCompanies();
    }
}
