package com.venkat.FiltersDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.UUID;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String token = httpRequest.getHeader("token");
        String apikey = httpRequest.getHeader("x-apikey");

        if(token == null || !token.equals("1234567")){
            httpResponse.setStatus(401);
            return;
        }

        if(apikey == null || !apikey.equals("Student123")){
            httpResponse.setStatus(401);
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write(
                    """
                            {
                                "message" : "Invalid api key"
                            }""");
            return;
        }



        chain.doFilter(request, response);
    }
}
