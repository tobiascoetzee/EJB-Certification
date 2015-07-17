package com.tobiascode.server;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class StatelessBean {

    public StatelessBean() {
        System.out.println(this.getClass().getSimpleName() + " - Constructor");
    }

    @PostConstruct
    private void initialise() {
        System.out.println(this.getClass().getSimpleName() + " - PostConstruct");
    }

    @PreDestroy
    private void breakDown() {
        System.out.println("*****************" + this.getClass().getSimpleName() + " - PreDestroy *****************");
    }

    private void otherInitialise() {
        System.out.println(this.getClass().getSimpleName() + " - Other PostConstruct");
    }

    private void otherBreakDown() {
        System.out.println("*****************" + this.getClass().getSimpleName() + " - Other PreDestroy *****************");
    }

    public String businessMethod(String name) {
        System.out.println(this.getClass().getSimpleName() + " - businessMethod");

        return "You asked the stateless bean for - " + name;
    }
}
