package com.tobiascode.client;

import com.tobiascode.server.ContainerTransaction;
import com.tobiascode.server.StatefulBean;

import javax.ejb.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@Singleton
@LocalBean
@Path(value="/container")
public class ContainerController {
    private Logger log = Logger.getLogger(this.getClass().getName());

    @EJB
    ContainerTransaction bean;

    @EJB
    StatefulBean statefulBean;

    @Path(value="/with")
    @GET
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public String withTransaction(){
        log.info("Entering withTransaction");

        log.info("Calling doWork");
        String result = bean.doWork();
        statefulBean.doWork();

        log.info("Exiting withTransaction");
        return result;
    }

    @Path(value="/without")
    @GET
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public String withoutTransaction(){
        log.info("Entering withoutTransaction");

        String result = "Nothing got done";

        try {
            log.info("Calling doWork");
            result = bean.doWork();
        } catch (EJBTransactionRequiredException ex){
            log.info("EJBTransactionRequiredException thrown");
        }

        log.info("Exiting withoutTransaction");
        return result;
    }
}
