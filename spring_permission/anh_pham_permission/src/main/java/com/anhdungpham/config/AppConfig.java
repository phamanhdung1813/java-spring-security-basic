package com.anhdungpham.config;


import com.anhdungpham.auth.CustomPermissionEvaluator;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true, //@Secure annotaion
        jsr250Enabled = true // @RolesAllow annotaion
)
public class AppConfig extends GlobalMethodSecurityConfiguration {
    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public UserDetailsService uds() {
        var uds = new InMemoryUserDetailsManager();

        var u1 = User.withUsername("user1")
                .password("user1")
                .authorities("read")
                .build();

        var u2 = User.withUsername("user2")
                .password("user2")
                .authorities("write")
                .build();

        uds.createUser(u1);
        uds.createUser(u2);

        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    public PermissionEvaluator permissionEvaluator() {
        return new CustomPermissionEvaluator();
    }

    @Override
    public MethodSecurityExpressionHandler createExpressionHandler() {
        var a = new DefaultMethodSecurityExpressionHandler();
        a.setPermissionEvaluator(permissionEvaluator());
        a.setApplicationContext(applicationContext);
        return a;
    }
}
