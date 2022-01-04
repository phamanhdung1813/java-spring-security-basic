package com.anhdungpham.lau_ren_1.auth.filters;

import com.anhdungpham.lau_ren_1.auth.authentication.OtpAuthentication;
import com.anhdungpham.lau_ren_1.auth.authentication.TokenAuthentication;
import com.anhdungpham.lau_ren_1.auth.authentication.UsernamePasswordAuthentication;
import com.anhdungpham.lau_ren_1.auth.token.AuthToken;
import com.anhdungpham.lau_ren_1.entities.OtpEntity;
import com.anhdungpham.lau_ren_1.repositories.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsernamePasswordFilter extends OncePerRequestFilter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private AuthToken authToken;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String username = request.getHeader("username");
        String password = request.getHeader("password");
        String otp = request.getHeader("otp");

        if (otp == null) {
            UsernamePasswordAuthenticationToken u = new UsernamePasswordAuthenticationToken(
                    username, password
            );
            Authentication auth = authenticationManager.authenticate(u);
            if (auth.isAuthenticated()) {
                OtpEntity otpEntity = new OtpEntity();
                otpEntity.setUsername(username);
                otpEntity.setOtp(String.valueOf(12345));
                otpRepository.save(otpEntity);
            } else {
                throw new BadCredentialsException("WRONG");
            }
        } else {
            UsernamePasswordAuthenticationToken u = new UsernamePasswordAuthenticationToken(
                    username, otp
            );
            Authentication auth = authenticationManager.authenticate(u);
            if (auth.isAuthenticated()) {
                authToken.add("OTP-AUTHORIZATION-TOKEN");
                response.setHeader("Authorization", "OTP-AUTHORIZATION-TOKEN");
            } else {
                throw new BadCredentialsException("WRONG");
            }
        }
    }

    @Override
    // Apply filter into all of pages before login
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/login");
    }
}
