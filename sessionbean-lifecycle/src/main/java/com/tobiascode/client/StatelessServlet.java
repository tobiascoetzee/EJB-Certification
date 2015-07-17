package com.tobiascode.client;

import com.tobiascode.server.StatelessBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatelessServlet extends HttpServlet {
    @EJB
    StatelessBean bean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append(bean.businessMethod("Spongebob"));
    }
}
