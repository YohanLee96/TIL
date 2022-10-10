package com.boot.actual.container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            response.getOutputStream().write("hello".getBytes());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
