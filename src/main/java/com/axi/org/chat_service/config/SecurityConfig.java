/*
package com.axi.org.chat_service.config;

import com.axi.org.chat_service.security.ApiKeyAuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SecurityConfig {

    @Bean
    public FilterRegistrationBean<ApiKeyAuthFilter> apiKeyAuthFilter(ApiKeyAuthFilter apiKeyAuthFilter) {
        FilterRegistrationBean<ApiKeyAuthFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(apiKeyAuthFilter);
        registrationBean.addUrlPatterns("/api/*"); // protect all endpoints under /api
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
*/
