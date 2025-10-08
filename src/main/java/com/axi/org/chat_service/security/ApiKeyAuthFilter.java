package com.axi.org.chat_service.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {

    @Value("${security.api-key}")
    private String configuredApiKey;

    private static final String API_KEY_HEADER = "X-API-KEY";
    private static final String PROTECTED_PATH_PREFIX = "/api/";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        if (path.startsWith(PROTECTED_PATH_PREFIX)) {
            String providedKey = request.getHeader(API_KEY_HEADER);

            if (providedKey == null || !providedKey.equals(configuredApiKey)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid or missing API key");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}