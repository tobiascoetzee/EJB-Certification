package com.tobiascode.server;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SecondBean {
    private int counter;
    public int getCounter(){
        counter++;
        return counter;
    }
    public SecondBean(){
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
}
