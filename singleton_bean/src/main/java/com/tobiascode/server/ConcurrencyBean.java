package com.tobiascode.server;

import javax.ejb.*;

@Singleton
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Lock(LockType.WRITE)
public class ConcurrencyBean {

    public void slowMethod(){
        System.out.println("Entering slowmethod");
        ssshh(10000);
        System.out.println("Exiting slowmethod");
    }

    public void fastMethod(){
        System.out.println("Entering fastMethod");
        ssshh(1000);
        System.out.println("Exit fastMethod");
    }
    private void ssshh(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
