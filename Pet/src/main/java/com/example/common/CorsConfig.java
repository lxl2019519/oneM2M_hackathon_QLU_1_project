package com.example.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    //The maximum valid duration of the current cross-domain request. Here is 1 day by default

    private static final long MAX_AGE = 24 * 60 * 60;

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 1   Set access source address
        corsConfiguration.addAllowedOrigin("*");
        // 2  Set access source request header
        corsConfiguration.addAllowedHeader("*");
        // 3  Set access source request method
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setMaxAge(MAX_AGE);
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 4  Configure cross-domain settings on the interface
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
