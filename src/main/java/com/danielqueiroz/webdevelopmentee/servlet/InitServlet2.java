package com.danielqueiroz.webdevelopmentee.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(loadOnStartup = 2, name = "Init2")
public class InitServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        System.out.println("LOG: Servlet 2 inicializado");
        System.out.println("ADMIN LOG: Enter with <"+config.getInitParameter("adminEmail")+">");
        ;

    }
}
