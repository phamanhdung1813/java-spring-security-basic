package com.anhdungpham.lau_ren.repositories;

import com.anhdungpham.lau_ren.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}
