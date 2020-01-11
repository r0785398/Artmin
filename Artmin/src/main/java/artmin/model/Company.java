/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.model;

import static java.nio.file.Files.size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

/**
 *
 * @author Rei
 */
@Entity
@Table(name="Company")
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userID", nullable=false)
    private Long userID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    
    @NotEmpty
    @Size(min=2,max=50)
    @Column(name = "name", nullable = false)
    private String name;
    
    @Size(min=2,max=30)
    @Column(name = "manager", nullable = true)
    private String manager;
    
    @Size(min=2,max=100)
    @Column(name = "street", nullable = true)
    private String street;
    
    @Size(max=25)
    @Column(name = "nrBus", nullable = true)
    private String nrBus;
    
    @Size(min=4,max=12)
    @Column(name = "postCode", nullable = true)
    private String postCode;
    
    @Size(min=2,max=50)
    @Column(name = "city", nullable = true)
    private String city;
    
    @Size(min=2,max=50)
    @Column(name = "country", nullable = true)
    private String country;
    
    @Size(min=2,max=25)
    @Column(name = "phone", nullable = true)
    private String phone;
    
    @Size(min=2,max=15)
    @Column(name = "vat", nullable = true)
    private String vat;
    
    @Email
    @Size(min=2,max=100)
    @Column(name = "email", nullable = true)
    private String email;
    
    @Size(max=255)
    @Column(name = "logoFilePath", nullable = true)
    private String logoFilePath;
    
    @Size(min=2,max=100)
    @Column(name = "bankAccount", nullable = true)
    private String bankAccount;
    
    @Size(max=4)
    @Column(name = "vatLegalLine", nullable = true)
    private boolean vatLegalLine;
    
    @Size(min=2,max=50)
    @Column(name = "invoicePreFix", nullable = true)
    private String invoicePreFix;
    
    @Size(max=20)
    @Column(name = "firstInvoiceNumber", nullable = true)
    private Long firstInvoiceNumber;
    
    @URL
    @Size(min=2,max=255)
    @Column(name = "termsAndConditionsUrl", nullable = true)
    private String termsAndConditionsUrl;
    
    
    
//    Properties

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNrBus() {
        return nrBus;
    }

    public void setNrBus(String nrBus) {
        this.nrBus = nrBus;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogoFilePath() {
        return logoFilePath;
    }

    public void setLogoFilePath(String logoFilePath) {
        this.logoFilePath = logoFilePath;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean isVatLegalLine() {
        return vatLegalLine;
    }

    public void setVatLegalLine(boolean vatLegalLine) {
        this.vatLegalLine = vatLegalLine;
    }

    public String getInvoicePreFix() {
        return invoicePreFix;
    }

    public void setInvoicePreFix(String invoicePreFix) {
        this.invoicePreFix = invoicePreFix;
    }

    public Long getFirstInvoiceNumber() {
        return firstInvoiceNumber;
    }

    public void setFirstInvoiceNumber(Long firstInvoiceNumber) {
        this.firstInvoiceNumber = firstInvoiceNumber;
    }

    public String getTermsAndConditionsUrl() {
        return termsAndConditionsUrl;
    }

    public void setTermsAndConditionsUrl(String termsAndConditionsUrl) {
        this.termsAndConditionsUrl = termsAndConditionsUrl;
    }

    
    
    
//    Methodes
    
    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return (int)result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Company))
            return false;
        Company other = (Company) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + "]";
    }
    
}
