package com.colak.springtutorial.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class InternalApiKeyAuthenticationFilter implements Filter {

    @Value("${internal.api-key}")
    private String internalApiKey;

    private final UnauthorizedHandler unauthorizedHandler;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String apiKey = httpServletRequest.getHeader("x-api-key");

        if (apiKey == null) {
            unauthorizedHandler.commence(httpServletRequest,httpServletResponse);
            return;
        }

        if (!internalApiKey.equals(apiKey)) {
            unauthorizedHandler.commence(httpServletRequest,httpServletResponse);
            return;
        }

        chain.doFilter(request, response);
    }
}
