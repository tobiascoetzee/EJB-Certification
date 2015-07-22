package com.tobiascode.client;

import com.tobiascode.server.FirstBean;
import com.tobiascode.server.SecondBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet2 extends HttpServlet {
    @EJB
    SecondBean bean;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            out.println(bean.getCounter());
            out.println(bean.getCounter());
            out.println(bean.getCounter());
            out.println(bean.getCounter());
            out.println("Done");
        }
    }
}
