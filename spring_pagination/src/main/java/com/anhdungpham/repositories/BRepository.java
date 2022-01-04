package com.anhdungpham.repositories;

import com.anhdungpham.entities.BEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BRepository extends JpaRepository<BEntity, Long> {
    BEntity findByBName(String name);
}
