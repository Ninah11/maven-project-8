/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject8;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tisha
 */
@Entity
@Table(name = "parent", catalog = "postgres", schema = "samdemo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parent.findAll", query = "SELECT p FROM Parent p")
    , @NamedQuery(name = "Parent.findByParentId", query = "SELECT p FROM Parent p WHERE p.parentId = :parentId")
    , @NamedQuery(name = "Parent.findByFullname", query = "SELECT p FROM Parent p WHERE p.fullname = :fullname")
    , @NamedQuery(name = "Parent.findByPersonalPhonenumber", query = "SELECT p FROM Parent p WHERE p.personalPhonenumber = :personalPhonenumber")
    , @NamedQuery(name = "Parent.findByWorkphonenumber", query = "SELECT p FROM Parent p WHERE p.workphonenumber = :workphonenumber")})
public class Parent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "parent_id", nullable = false)
    private Integer parentId;
    @Size(max = 50)
    @Column(name = "fullname", length = 50)
    private String fullname;
    @Size(max = 15)
    @Column(name = "personal_phonenumber", length = 15)
    private String personalPhonenumber;
    @Size(max = 255)
    @Column(name = "workphonenumber", length = 255)
    private String workphonenumber;
    @OneToMany(mappedBy = "cityId")
    private List<School> schoolList;

    public Parent() {
    }

    public Parent(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPersonalPhonenumber() {
        return personalPhonenumber;
    }

    public void setPersonalPhonenumber(String personalPhonenumber) {
        this.personalPhonenumber = personalPhonenumber;
    }

    public String getWorkphonenumber() {
        return workphonenumber;
    }

    public void setWorkphonenumber(String workphonenumber) {
        this.workphonenumber = workphonenumber;
    }

    @XmlTransient
    public List<School> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parentId != null ? parentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parent)) {
            return false;
        }
        Parent other = (Parent) object;
        if ((this.parentId == null && other.parentId != null) || (this.parentId != null && !this.parentId.equals(other.parentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject8.Parent[ parentId=" + parentId + " ]";
    }
    
}
