package com.jerome.demo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(this.getClass().getName() + "初始化");
    }

    @Override
    public void destroy() {
        System.out.println(this.getClass().getName() + "销毁");
    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) srequest;
        String uri = request.getRequestURI();
        System.out.println("filter url = " + uri);
        filterChain.doFilter(srequest, sresponse);
    }

}
