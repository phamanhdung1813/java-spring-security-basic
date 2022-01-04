package com.anhdungpham.repositories;

import com.anhdungpham.entities.AEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ARepository extends JpaRepository<AEntity, Long> {
    AEntity findByAName(String name);
}
