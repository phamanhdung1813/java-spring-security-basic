package com.anhdungpham.auth;

import com.anhdungpham.model.Document;

import java.util.List;

public interface IMethodAuthorizationManager {
    boolean implementSecurityConfig(List<Document> returnedList, String permission);
}
