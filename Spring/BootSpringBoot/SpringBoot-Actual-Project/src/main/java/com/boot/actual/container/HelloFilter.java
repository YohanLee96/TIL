package com.boot.actual.container;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/hello")
public class HelloFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        response.getOutputStream().println("filtering");
        response.getOutputStream().println("servlet-context-attr:"
                + request.getServletContext().getAttribute("servlet-context-attr"));
        //Servlet컨테이너에 저장된 속성 가져오기. -> AttrListener에서
        // 웹어플리케이션 초기화 시, servlet-context-attr라는 이름으로 추가.
        chain.doFilter(request, response);
        chain.doFilter(request, response); //체인의 마지막요소인 서블릿을 불러오기위해 2번 호출.
    }
}
