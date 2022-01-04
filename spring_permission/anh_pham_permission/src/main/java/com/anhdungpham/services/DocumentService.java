package com.anhdungpham.services;

import com.anhdungpham.model.Document;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    //    @PostAuthorize("hasPermission(returnObject, 'read')")
    @PostAuthorize("@customMethodAuthorizationManager.implementSecurityConfig(returnObject, 'read')")
    public List<Document> findDocuments(String username) {
        var a = new Document();
        a.setText("TEXT");
        a.setUser(username);
        return List.of(a);
    }
}
