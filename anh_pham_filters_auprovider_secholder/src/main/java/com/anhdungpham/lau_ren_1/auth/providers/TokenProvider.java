package com.anhdungpham.lau_ren_1.auth.providers;

import com.anhdungpham.lau_ren_1.auth.authentication.TokenAuthentication;
import com.anhdungpham.lau_ren_1.auth.token.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class TokenProvider implements AuthenticationProvider {
    @Autowired
    private AuthToken authToken;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = authentication.getName(); // name token
        var a = authToken.check(token);
        if (a) {
            return new TokenAuthentication(token, null, null);
        }
        throw new BadCredentialsException("WRONG");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthentication.class.equals(authentication);
    }
}
