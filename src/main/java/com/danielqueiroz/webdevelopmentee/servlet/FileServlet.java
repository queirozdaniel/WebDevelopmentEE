package com.danielqueiroz.webdevelopmentee.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "FileServlet", value = "/FileServlet")
public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/zip");
        response.addHeader("Content-Disposition", "attachment; filename=arquivo.zip;");

        try (FileInputStream in = new FileInputStream("C:/Temp/arquivo.zip");
             OutputStream out = response.getOutputStream()){

            byte[] buffer = new byte[1024];
            int b;

            while ((b = in.read()) > -1){
                out.write(buffer, 0, b);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
