package com.tobiascode.server;

import javax.annotation.Resource;
import javax.ejb.*;
import java.util.concurrent.Future;

@Stateless
@LocalBean
public class AsyncBean {
    @Resource
    private SessionContext sessionContext;

    @Asynchronous
    public void noValue(){
        System.out.println(this.getClass().getSimpleName() + " - I'm not returning anything");
    }

    @Asynchronous
    public Future<String> returnValue(){
        System.out.println(this.getClass().getSimpleName() + " - I'm returning a value");

        shhh(2000);

        return new AsyncResult<String>("Some value");
    }

    @Asynchronous
    public Future<String> cancelMe(){
        while(true){
            System.out.println(this.getClass().getSimpleName() + " - I'm still going!");
            shhh(2000);
            if (sessionContext.wasCancelCalled()){
                System.out.println(this.getClass().getSimpleName() + " - I have been cancelled!");
                break;
            }
        }

        return new AsyncResult<String>("");
    }

    private void shhh(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}
