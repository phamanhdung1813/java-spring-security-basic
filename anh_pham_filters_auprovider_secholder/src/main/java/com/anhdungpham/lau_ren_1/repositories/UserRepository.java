package com.anhdungpham.lau_ren_1.repositories;

import com.anhdungpham.lau_ren_1.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}
