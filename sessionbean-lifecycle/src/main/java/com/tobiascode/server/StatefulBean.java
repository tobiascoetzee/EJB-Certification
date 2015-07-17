package com.tobiascode.server;

import org.omg.CORBA.SystemException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import java.io.IOException;

@Stateful
public class StatefulBean {

    public StatefulBean(){
        System.out.println(this.getClass().getSimpleName() + " - Constructor");
    }

    @PostConstruct
    private void initialise(){
        System.out.println(this.getClass().getSimpleName() + " - PostConstruct");
    }

    @PreDestroy
    private void breakDown(){
        System.out.println("*****************" + this.getClass().getSimpleName() + " - PreDestroy *****************");
    }

    @Remove
    public void removeBean(){
        System.out.println(this.getClass().getSimpleName() + " - Remove");
    }

    @PrePassivate
    private void goingToSleep(){
        System.out.println(this.getClass().getSimpleName() + " - PrePassivate");
    }

    @PostActivate
    private void wakingUp(){
        System.out.println(this.getClass().getSimpleName() + " - PostActivate");
    }

    public String businessMethod(String name){
        System.out.println(this.getClass().getSimpleName() + " - businessMethod");

        return "You asked the stateful bean for - " + name;
    }
}
