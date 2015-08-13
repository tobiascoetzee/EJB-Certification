package com.tobiascode.server;

import javax.annotation.PostConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class Intercept {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @PostConstruct
    public void initializeIntercept(InvocationContext context){
        log.info("Start lifecycle intercepting - " + context.getTarget());

        try {
            context.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("End lifecycle intercepting - " + context.getTarget());
    }

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception{
        log.info("Start class intercepting - " + context.getMethod().getName());

        Object theResult = context.proceed();

        log.info("End class intercepting - " + context.getMethod().getName());

        return theResult;
    }
}
