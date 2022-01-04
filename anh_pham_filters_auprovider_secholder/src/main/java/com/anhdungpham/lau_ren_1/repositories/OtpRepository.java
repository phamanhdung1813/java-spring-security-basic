package com.anhdungpham.lau_ren_1.repositories;

import com.anhdungpham.lau_ren_1.entities.OtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<OtpEntity, Integer> {
    OtpEntity findOtpByUsername(String username);
}
