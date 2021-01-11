package com.danielqueiroz.webdevelopmentee.servlet;

import com.danielqueiroz.webdevelopmentee.model.Produto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MessageServlet", value = "/MessageServlet")
public class MessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        Produto x = new Produto();
        Produto y = new Produto();

        HttpSession session = request.getSession();
        session.setAttribute("p1", x);
        session.setAttribute("p2", y);


        try(PrintWriter out = response.getWriter()){
            out.print("<html><body>");
            out.print("<h1>Primerio Servlet<h1/>");
            out.print("<h3>Está funcionando...<h3/>");

            out.println("<p>Produto 1: " + x.getNome() +"</p>");
            out.println("<p>Produto 2: " + y.getNome() +"</p>");

            out.print("<body/><html/>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
