package com.anhdungpham.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class AppConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().anyRequest().permitAll();
        http.cors(cors -> {
            CorsConfigurationSource ccs = cc -> {
                CorsConfiguration c = new CorsConfiguration();
                c.setAllowedOrigins(List.of("*"));
                c.setAllowedMethods(List.of("POST", "GET"));
                return c;
            };
        });
    }
}
