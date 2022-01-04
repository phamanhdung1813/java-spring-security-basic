package com.anhdungpham.lau_ren_1.auth.providers;

import com.anhdungpham.lau_ren_1.auth.authentication.OtpAuthentication;
import com.anhdungpham.lau_ren_1.auth.authentication.TokenAuthentication;
import com.anhdungpham.lau_ren_1.repositories.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class OtpProvider implements AuthenticationProvider {
    @Autowired
    private OtpRepository otpRepository;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String otp = authentication.getCredentials().toString();
        var u = otpRepository.findOtpByUsername(username);
        if (u != null) {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    username, otp, null
            );
            return authenticationToken;
        } else {
            throw new BadCredentialsException("WRONG");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
