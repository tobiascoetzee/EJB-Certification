package com.tobiascode.server;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class HelloBean {
    public String sayHello(){
        return "Hello World";
    }
}
