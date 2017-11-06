/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutoo;

import com.mycompany.mavenproject8.Employee;
import ejb.NewSessionBean;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Tisha
 */
@Named(value = "mutoManagedBean")
@ViewScoped
public class MutoManagedBean implements Serializable{
    private String employee;
    private String firstname;
    private String lastname;
    private int salary;
    @EJB 
    private NewSessionBean newSessionBean;
    private int id;

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
public void saveemployee(){
    try {
        Employee ninah = new Employee();
        ninah.setFirstname(firstname);
        ninah.setLastname(lastname);
        ninah.setSalary(salary);
        Employee createEmployee2 = newSessionBean.createEmployee2(ninah);
        setId(createEmployee2.getEmployeeId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "new employee","Thank you for recording"));
    } catch (Exception e) {
        Logger.getLogger("ManagedBean").log(Level.SEVERE, e.getMessage(), e);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
    }
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /**
     * Creates a new instance of MutoManagedBean
     */
    public MutoManagedBean() {
    }
    
}
