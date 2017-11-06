/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webresource;

import com.mycompany.mavenproject8.Employee;
import ejb.NewSessionBean;
import ejb.ValidatorUtil;
import java.util.concurrent.ExecutorService;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Tisha
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;
    @EJB
    private NewSessionBean newSessionBean;
    @EJB
    private ValidatorUtil validatorUtil;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of webresource.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        //TODO return proper representation object
        return "hello world";
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public String putXml(String content) {
        return "my content is " + content;

    }
    private ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();

    /**
     *
     * @param asyncResponse
     * @param ninah
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void postcontent(@Suspended
            final AsyncResponse asyncResponse, final Employee ninah) {

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doPostcontent(ninah));
            }
        });

    }

    private Response doPostcontent(Employee ninah) {

        Response validate = validatorUtil.validate(ninah);
        if (validate != null) {
            return validate;
        }
        return newSessionBean.createEmployee(ninah);

    }
}
