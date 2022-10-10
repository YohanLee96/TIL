package com.boot.actual.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration
public class FilterConfig {

    @Bean
    public Filter myFilter() {
        return new Filter() {
            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

            }
        };
    }
}
