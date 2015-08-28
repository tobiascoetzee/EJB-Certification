package com.tobiascode.client;

import com.tobiascode.server.ProgrammaticTimer;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Singleton
@Path(value = "/timer")
public class Controller {
    @EJB
    private ProgrammaticTimer bean;

    @GET
    @Path("/start")
    public String startTimer(){
        bean.startTimer();

        return "Ok";
    }

    @GET
    @Path("/stop")
    public String stopTimer(){
        bean.stopTimer();

        return "Ok";
    }
}
