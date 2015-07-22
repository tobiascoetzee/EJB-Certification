package com.tobiascode.server;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@LocalBean
@Startup
@DependsOn("SecondBeanX")
public class FirstBean {
    private int counter;

    public FirstBean(){
        System.out.println(this.getClass().getSimpleName() + " - Constructor");
    }

    @PostConstruct
    private void initialise(){
        System.out.println(this.getClass().getSimpleName() + " - PostConstruct");
    }

    @PreDestroy
    private void remove(){
        System.out.println(this.getClass().getSimpleName() + " - PreDestroy");
    }

    public int getCounter(){
        counter++;
        return counter;
    }
}
