package com.venkat.FiltersDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
@Order(2)
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

        String requestId = UUID.randomUUID().toString();
        httpResponse.setHeader("x-request-id", requestId);

        long startTime = System.currentTimeMillis();
        //Request Logs
        System.out.println("Incoming Request : "
                + httpRequest.getMethod() + " "
                + httpRequest.getRequestURI());

        //next filter continuation
        try {
            chain.doFilter(request, response);
        }
        finally {
            long responseTime = System.currentTimeMillis() - startTime;

            //Response logs
            System.out.println("Response Status : "
                    + httpResponse.getStatus());

            System.out.println("Response Time : "+ responseTime);
        }

    }
}
