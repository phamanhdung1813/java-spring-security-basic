package com.anhdungpham.lau_ren_1.config;

import com.anhdungpham.lau_ren_1.auth.filters.TokenFilter;
import com.anhdungpham.lau_ren_1.auth.filters.UsernamePasswordFilter;
import com.anhdungpham.lau_ren_1.auth.providers.OtpProvider;
import com.anhdungpham.lau_ren_1.auth.providers.TokenProvider;
import com.anhdungpham.lau_ren_1.auth.providers.UserProvider;
import com.anhdungpham.lau_ren_1.services.CustomUserDetailsService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private UserProvider userProvider;

    @Autowired
    private TokenProvider tokenProvider;


    @Autowired
    private OtpProvider otpProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(userProvider)
                .authenticationProvider(otpProvider)
                .authenticationProvider(tokenProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterAt(usernamePasswordAuthFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(tokenFilter(), BasicAuthenticationFilter.class);
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public UsernamePasswordFilter usernamePasswordAuthFilter() {
        return new UsernamePasswordFilter();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public InitializingBean initializingBean() {
        return () -> {
            SecurityContextHolder.setStrategyName(
                    SecurityContextHolder.MODE_INHERITABLETHREADLOCAL
            );
        };
    }
}
