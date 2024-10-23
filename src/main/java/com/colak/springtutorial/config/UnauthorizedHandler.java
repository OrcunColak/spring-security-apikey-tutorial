package com.colak.springtutorial.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class UnauthorizedHandler implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException exception)
            throws IOException {
        commence(httpServletRequest, httpServletResponse);
    }

    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse)
            throws IOException {
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        // Create response
        Map<String, Object> response = Map.of("Access denied: x-api-key header is required.", "SC_UNAUTHORIZED");
        String responseBody = objectMapper.writeValueAsString(response);

        httpServletResponse.getWriter().write(responseBody);
    }
}
