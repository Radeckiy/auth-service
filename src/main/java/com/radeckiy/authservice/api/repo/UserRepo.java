package com.radeckiy.authservice.api.repo;

import com.radeckiy.authservice.api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <UserEntity, Long>{
    UserEntity findByUsername(String username);
}
