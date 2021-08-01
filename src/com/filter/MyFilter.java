package com.filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MyFilter",urlPatterns ="/*")

public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest =(HttpServletRequest) req;
        HttpSession session = httpRequest.getSession();
        String name =(String) session.getAttribute("userName");
        String path=((HttpServletRequest) req).getServletPath();
        if(name!=null){
            chain.doFilter(req, resp);
        }
        if("/login".equals(path) || "/login.html".equals(path)){
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
