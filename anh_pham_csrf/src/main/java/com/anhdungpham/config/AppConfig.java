package com.anhdungpham.config;

import com.anhdungpham.auth.CsrfLoggerFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class AppConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
//        http.csrf().disable();
        http.csrf(token -> {
            token.ignoringAntMatchers("/doSth/**");
        });
       http.addFilterAfter(new CsrfLoggerFilter(), CsrfFilter.class);
    }
}
