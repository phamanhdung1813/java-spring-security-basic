package com.anhdungpham.controllers;

import com.anhdungpham.entities.ProductEntity;
import com.anhdungpham.repositories.ProductRepository;
import com.anhdungpham.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(value = "*", maxAge = 3600L)
@RequiredArgsConstructor
@RequestMapping(value = "/api/pagination")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAll(@RequestParam(required = false, name = "fieldName") String fieldName,
                                                      @RequestParam(defaultValue = "0", name = "offset") int offset,
                                                      @RequestParam(defaultValue = "3", name = "limit") int limit) {
        Map<String, Object> response = new HashMap<>();
        // Paging
        if (fieldName == null) {
            Pageable pageable = PageRequest.of(offset, limit); //default ASC
            Page<ProductEntity> pageAll = productRepository.findAll(pageable);
            response.put("totalElement", pageAll.getTotalElements());
            response.put("responseData", pageAll.getContent());
            response.put("totalPage", pageAll.getTotalPages());
            response.put("currentPage", pageAll.getNumber());
            // Arrange by Column and Paging by limit offset
        } else {
            Page<ProductEntity> pagingField = productService.findByFieldAndPaging(offset, limit, fieldName);
            response.put("totalElement", pagingField.getTotalElements());
            response.put("responseData", pagingField.getContent());
            response.put("totalPage", pagingField.getTotalPages());
            response.put("currentPage", pagingField.getNumber());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
