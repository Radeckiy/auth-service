package com.radeckiy.authservice.api.repo;

import com.radeckiy.authservice.api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
