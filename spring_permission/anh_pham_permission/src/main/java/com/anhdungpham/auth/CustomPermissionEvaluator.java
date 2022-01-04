package com.anhdungpham.auth;

import com.anhdungpham.model.Document;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;
import java.util.List;

public class CustomPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication,
                                 Object targetDomainObject, Object permission) {
        List<Document> returnedList = (List<Document>) targetDomainObject;
        String username = authentication.getName();
        String authMapper = (String) permission;

        boolean b1 = returnedList.stream().allMatch(i -> i.getUser().equals(username));

        boolean b2 = authentication.getAuthorities().stream().anyMatch(
                i -> i.getAuthority().contains(authMapper)
        );

        return b1 && b2;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
