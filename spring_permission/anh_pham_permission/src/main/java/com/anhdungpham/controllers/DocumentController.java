package com.anhdungpham.controllers;

import com.anhdungpham.model.Document;
import com.anhdungpham.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/documents/{username}")
    public List<Document> findDocuments(@PathVariable String username) {
        return documentService.findDocuments(username);
    }

}
