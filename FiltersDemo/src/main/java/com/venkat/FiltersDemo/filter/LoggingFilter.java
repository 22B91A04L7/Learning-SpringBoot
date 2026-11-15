package com.venkat.FiltersDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {
    private final ServletRequest servletRequest;
    private final ServletResponse servletResponse;

    public LoggingFilter(ServletRequest servletRequest, ServletResponse servletResponse) {
        this.servletRequest = servletRequest;
        this.servletResponse = servletResponse;
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        //Request Logs
        System.out.println("Incoming Request : "
                + httpRequest.getMethod() + " "
                + httpRequest.getRequestURI());

        //next filter continuation
        chain.doFilter(request, response);

        //Response logs
        System.out.println("Response Status : "
        + httpResponse.getStatus());
    }
}
