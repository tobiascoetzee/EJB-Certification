package com.tobiascode.server;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Stateless
@LocalBean
public class Bean {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    public String callMe(){
        log.info("callMe method called");

        return "Hellooo Nurse!";
    }

    @PostConstruct
    private void initialize(){
        log.info("Initializing - " + this);
    }

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception{
        log.info("Start intercepting - " + context.getMethod().getName());

        Object theResult = context.proceed();

        log.info("End intercepting - " + context.getMethod().getName());

        return theResult;
    }
}
