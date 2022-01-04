package com.anhdungpham.auth;

import com.anhdungpham.model.Document;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomMethodAuthorizationManager implements IMethodAuthorizationManager {

    @Override
    public boolean implementSecurityConfig(List<Document> returnedList, String permission) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        boolean b1 = returnedList.stream().allMatch(i -> i.getUser().equals(username));

        boolean b2 = authentication.getAuthorities().stream().anyMatch(
                i -> i.getAuthority().contains(permission)
        );
        return b1 && b2;
    }
}
