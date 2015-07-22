package com.tobiascode.client;

import com.tobiascode.server.ConcurrencyBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet3 extends HttpServlet {
    @EJB
    ConcurrencyBean bean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Starting doGet");

        System.out.println("Calling slowMethod");
        new Thread(){
            public void run(){
                bean.slowMethod();
            }
        }.start();

        System.out.println("Calling fastMethod");
        new Thread(){
            public void run(){
                bean.fastMethod();
            }
        }.start();

        System.out.println("Ending doGet");
    }
}
