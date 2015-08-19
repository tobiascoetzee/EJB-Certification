package com.tobiascode.server;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.SessionSynchronization;
import javax.ejb.Stateful;
import java.rmi.RemoteException;
import java.util.logging.Logger;

@Stateful
@LocalBean
public class StatefulBean implements SessionSynchronization{
    private Logger log = Logger.getLogger(this.getClass().getName());

    public void doWork(){
        log.info("Doing some stateful work.");
    }

    @Override
    public void afterBegin() throws EJBException, RemoteException {
        log.info("Calling afterBegin");
    }

    @Override
    public void beforeCompletion() throws EJBException, RemoteException {
        log.info("Calling beforeCompletion");
    }

    @Override
    public void afterCompletion(boolean b) throws EJBException, RemoteException {
        log.info("Calling afterCompletion");
    }
}
