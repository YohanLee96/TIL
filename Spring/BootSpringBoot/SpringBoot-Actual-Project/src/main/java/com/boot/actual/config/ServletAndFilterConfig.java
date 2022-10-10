package com.boot.actual.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;

@Configuration
public class ServletAndFilterConfig {

   // @Bean
    public FilterRegistrationBean<Filter> registration(Filter myFilter) {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>(myFilter);

        registration.setEnabled(true);
        return registration;
    }

  //  @Bean
    public ServletRegistrationBean<Servlet> servletRegistration(Servlet myServlet) {
        ServletRegistrationBean<Servlet> registration = new ServletRegistrationBean<>(myServlet);

        registration.setEnabled(true);

        return registration;
    }
}
