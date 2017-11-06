/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject8;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tisha
 */
@Entity
@Table(name = "phone", catalog = "postgres", schema = "samdemo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")
    , @NamedQuery(name = "Phone.findById", query = "SELECT p FROM Phone p WHERE p.id = :id")
    , @NamedQuery(name = "Phone.findByAreaCode", query = "SELECT p FROM Phone p WHERE p.areaCode = :areaCode")
    , @NamedQuery(name = "Phone.findByTypephone", query = "SELECT p FROM Phone p WHERE p.typephone = :typephone")
    , @NamedQuery(name = "Phone.findByPhoneNumber", query = "SELECT p FROM Phone p WHERE p.phoneNumber = :phoneNumber")})
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Size(max = 3)
    @Column(name = "area_code", length = 3)
    private String areaCode;
    
    @Size(max = 15)
    @Column(name = "typephone", length = 2147483647)
    private String typephone;
    
    @Size(max = 2147483647)
    @Column(name = "phone_number", length = 2147483647)
    private String phoneNumber;
    
    @JoinColumn(name = "owner_id", referencedColumnName = "employee_id")
    @ManyToOne
    private Employee ownerId;

    public Phone() {
    }

    public Phone(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getTypephone() {
        return typephone;
    }

    public void setTypephone(String typephone) {
        this.typephone = typephone;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Employee ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject8.Phone[ id=" + id + " ]";
    }
    
}
