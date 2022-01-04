package com.anhdungpham.services;

import com.anhdungpham.entities.ProductEntity;
import com.anhdungpham.repositories.ProductRepository;
import com.anhdungpham.services.imp.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    @Override
    @PostConstruct
    public void initializeDatabase() {
//        List<ProductEntity> productEntityList = IntStream.rangeClosed(1, 10)
//                .mapToObj(i -> new ProductEntity("product" + i, new Random().nextInt(100)))
//                .collect(Collectors.toList());
//        productRepository.saveAll(productEntityList);
    }

    @Override
    public Page<ProductEntity> findByFieldAndPaging(int offset, int limit, String fieldName) {
        return productRepository.findAll(PageRequest.of(offset, limit).withSort(Sort.by(Sort.Direction.ASC, fieldName)));
        // default is ASC
    }
}
