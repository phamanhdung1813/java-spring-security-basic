package com.anhdungpham.services.imp;

import com.anhdungpham.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    void initializeDatabase();

    Page<ProductEntity> findByFieldAndPaging(int offset, int limit, String fieldName);

}
