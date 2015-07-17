package com.tobiascode.client;

import com.tobiascode.server.AsyncBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Stateless
@Path("/async")
public class Controller {
    @EJB
    private AsyncBean bean;

    @GET
    @Path("/none")
    public String noResult(){
        System.out.println(this.getClass().getSimpleName() + " - Getting nothing");
        bean.noValue();
        return "Done";
    }

    @GET
    @Path("/value")
    public String someValue(){
        System.out.println(this.getClass().getSimpleName() + " - Getting a value");
        Future<String> futureValue = bean.returnValue();
        String value = "";

        try {
            value = futureValue.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(this.getClass().getSimpleName() + " - Got a value");

        return value;
    }

    @GET
    @Path("/cancel")
    public String canCancel(){
        System.out.println(this.getClass().getSimpleName() + " - Canceling a value");
        Future<String> cancelme = bean.cancelMe();

        shhh(4000);
        cancelme.cancel(true);
        shhh(2000);

        System.out.println(this.getClass().getSimpleName() + " - I'm done");

        return "Done";
    }

    private void shhh(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}
