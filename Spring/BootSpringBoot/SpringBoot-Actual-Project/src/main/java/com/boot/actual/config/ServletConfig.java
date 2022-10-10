package com.boot.actual.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Slf4j
@Configuration
public class ServletConfig {

    public Servlet myServlet() {
        return new Servlet() {
            @Override
            public void init(javax.servlet.ServletConfig config) throws ServletException {

                log.info("");
            }

            @Override
            public javax.servlet.ServletConfig getServletConfig() {
                return null;
            }

            @Override
            public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

            }

            @Override
            public String getServletInfo() {
                return null;
            }

            @Override
            public void destroy() {

            }
        };
    }
}
