package com.boot.actual.container;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AttrListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("servlet-context-attr", "honeymon");
    }

}
