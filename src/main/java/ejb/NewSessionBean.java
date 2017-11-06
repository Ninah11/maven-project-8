/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import com.mycompany.mavenproject8.Employee;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Tisha
 */
@Stateless
public class NewSessionBean {

    @PersistenceContext(unitName = "com.mycompany_mavenproject8_war_1PU")
    private EntityManager em;
    private static final Logger LOG = Logger.getLogger(NewSessionBean.class.getName());

    public Response createEmployee(Employee nina) {
        try {
//           if (nina.getFirstname() == null){
//               return Response.status(Response.Status.BAD_REQUEST).entity("Firstname is null").type(MediaType.TEXT_PLAIN).build();
//                 }
//            if (nina.getFirstname().isEmpty()) {
//                return Response.status(Response.Status.BAD_REQUEST).entity("First name is null").type(MediaType.TEXT_PLAIN).build();
//            }
//            if (nina.getLastname().isEmpty()) {
//                return Response.status(Response.Status.BAD_REQUEST).entity("Last name is null").type(MediaType.TEXT_PLAIN).build();
//            }
//            if (nina.getSalary() > 5000000) {
//                return Response.status(Response.Status.BAD_REQUEST).entity("Amount is more than maximum").type(MediaType.TEXT_PLAIN).build();
//            }
            return Response.status(Response.Status.OK).entity(em.merge(nina)).type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }

    }

    public Employee createEmployee2(Employee ninah) {
        return em.merge(ninah);

    }
}
