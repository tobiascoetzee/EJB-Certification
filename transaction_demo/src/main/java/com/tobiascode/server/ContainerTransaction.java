package com.tobiascode.server;

import javax.ejb.*;
import java.util.logging.Logger;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContainerTransaction {
    private Logger log = Logger.getLogger(this.getClass().getName());

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public String doWork(){
        log.info("Doing some work");

        return "My work here is done";
    }
}
