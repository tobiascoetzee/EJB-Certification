package com.tobiascode.client;

import com.tobiascode.server.InjServer;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

public class InjClient {
    public static void main(String... args) throws NamingException {
        EJBContainer container = EJBContainer.createEJBContainer();
        InjServer bean = (InjServer) container.getContext().lookup("java:global/ejb-inj-demo/InjServer");

        System.out.println("getInitialContextNumber: " + bean.getInitialContextNumber());
        System.out.println("getEjbContextNumber: " + bean.getEjbContextNumber());
        System.out.println("getMyNumber: " + bean.getMyNumber());
        System.out.println("getTheNumber: " + bean.getTheNumber());
        System.out.println("getMyName: " + bean.getMyName());
        System.out.println("getOtherName: " + bean.getOtherName());
    }
}
