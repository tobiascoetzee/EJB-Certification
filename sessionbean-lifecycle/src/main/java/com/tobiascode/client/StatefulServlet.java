package com.tobiascode.client;

import com.tobiascode.server.StatefulBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatefulServlet extends HttpServlet {
    @EJB
    StatefulBean bean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append(bean.businessMethod("Spongebob"));
        bean.removeBean();
        response.getWriter().append(" - Done");
    }
}
