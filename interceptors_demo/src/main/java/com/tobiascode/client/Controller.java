package com.tobiascode.client;

import com.tobiascode.server.Bean;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.interceptor.ExcludeDefaultInterceptors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Singleton
@Path(value = "call")
public class Controller {
    @EJB
    Bean bean;

    @Path(value = "me")
    @GET
    public String meMethod(){
        return bean.callMe();
    }
}
