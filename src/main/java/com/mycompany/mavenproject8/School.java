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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tisha
 */
@Entity
@Table(name = "school", catalog = "postgres", schema = "samdemo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "School.findAll", query = "SELECT s FROM School s")
    , @NamedQuery(name = "School.findBySchoolId", query = "SELECT s FROM School s WHERE s.schoolId = :schoolId")
    , @NamedQuery(name = "School.findByLocation", query = "SELECT s FROM School s WHERE s.location = :location")
    , @NamedQuery(name = "School.findBySchoolName", query = "SELECT s FROM School s WHERE s.schoolName = :schoolName")
    , @NamedQuery(name = "School.findByStudentNumbers", query = "SELECT s FROM School s WHERE s.studentNumbers = :studentNumbers")})
public class School implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "school_id", nullable = false)
    private Integer schoolId;
    @Size(max = 15)
    @Column(name = "location", length = 15)
    private String location;
    @Size(max = 50)
    @Column(name = "school_name", length = 50)
    private String schoolName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "student_numbers", nullable = false)
    private int studentNumbers;
    @JoinColumn(name = "city_id", referencedColumnName = "parent_id")
    @ManyToOne
    private Parent cityId;

    public School() {
    }

    public School(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public School(Integer schoolId, int studentNumbers) {
        this.schoolId = schoolId;
        this.studentNumbers = studentNumbers;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getStudentNumbers() {
        return studentNumbers;
    }

    public void setStudentNumbers(int studentNumbers) {
        this.studentNumbers = studentNumbers;
    }

    public Parent getCityId() {
        return cityId;
    }

    public void setCityId(Parent cityId) {
        this.cityId = cityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schoolId != null ? schoolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        if ((this.schoolId == null && other.schoolId != null) || (this.schoolId != null && !this.schoolId.equals(other.schoolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject8.School[ schoolId=" + schoolId + " ]";
    }
    
}
