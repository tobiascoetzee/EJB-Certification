package com.tobiascode.server;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Singleton
@LocalBean
public class InjServer {
    @Resource
    EJBContext ejbContext;

    @Resource
    private int myNumber;

    @Resource(name = "myNumber")
    private int theNumber;

    private String otherName;

    private String myName = "Patrick";

    @Resource(name = "myName")
    public void setTheName(String name){
        otherName = name;
    }

    // Value injected using InitialContext
    public int getInitialContextNumber(){
        int number = 0;

        try {
            //InitialContext initialContext = new InitialContext();
            //number = (Integer)initialContext.lookup("java:comp/env/myNumber");
            number = InitialContext.doLookup("java:comp/env/myNumber");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        return number;
    }

    // Value injected using EJBContext
    public int getEjbContextNumber() {
        return (Integer)ejbContext.lookup("myNumber");
    }

    // Value injected via field injection on myNumber using type and name
    public int getMyNumber(){
        return theNumber;
    }

    // Value injected via field injection on theNumber field using 'name' parameter
    public int getTheNumber(){
        return theNumber;
    }

    // Value injected via deployment descriptor
    public String getMyName(){
        return myName;
    }

    // Value injected via method injection on setTheName method
    public String getOtherName(){
        return otherName;
    }

}
