package com.tobiascode.client;

import com.tobiascode.server.BeanTransaction;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@Singleton
@LocalBean
@Path(value="/bean")
public class BeanController {
    private Logger log = Logger.getLogger(this.getClass().getName());

    @EJB
    private BeanTransaction bean;

    @Path(value = "/commit")
    @GET
    public String commitTransactions(){
        log.info("Entering commitTransactions");

        String result = bean.doWork(true);

        log.info("Exiting commitTransactions");
        return result;
    }

    @Path(value = "/rollback")
    @GET
    public String rollbackTransactions(){
        log.info("Entering rollbackTransactions");

        String result = bean.doWork(false);

        log.info("Exiting rollbackTransactions");
        return result;
    }
}
